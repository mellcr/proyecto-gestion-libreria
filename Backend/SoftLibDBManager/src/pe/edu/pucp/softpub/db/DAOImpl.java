package pe.edu.pucp.softpub.db;

// Casco_Once

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import pe.edu.pucp.softlib.config.DBManager;

public abstract class DAOImpl {

    protected String nombre_tabla;
    protected Connection conexion;
    protected CallableStatement statement;
    protected ResultSet resultSet;
    protected Boolean mostrarSentenciaSQL;
    protected Boolean retornarLlavePrimaria;
    protected Boolean usarTransaccion;
    protected Tipo_Operacion tipo_Operacion;

    public DAOImpl(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
        this.mostrarSentenciaSQL = true;
        this.retornarLlavePrimaria = false;
        this.usarTransaccion = true;
        this.tipo_Operacion = null;
    }

    protected void iniciarTransaccion() throws SQLException {
        this.abrirConexion();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected void abrirConexion() {
        this.conexion = DBManager.getInstance().getConnection();
    }

    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
            this.conexion = null;
        }
    }

    protected void colocarSQLenStatement(String sql) throws SQLException {
        if (this.mostrarSentenciaSQL) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.INFO, sql);
        }
        this.statement = this.conexion.prepareCall(sql);
    }

    protected Integer ejecutarModificacionEnBD(String sql) throws SQLException {
        return this.statement.executeUpdate();
    }

    protected void ejecutarConsultaEnBD(String sql) throws SQLException {
        this.resultSet = this.statement.executeQuery();
    }

    private Integer ejecuta_DML(Tipo_Operacion tipo_Operacion) {
        Integer resultado = 0;
        this.tipo_Operacion = tipo_Operacion;
        try {
            if (this.usarTransaccion) {
                this.iniciarTransaccion();
            }
            String sql = null;
            switch (tipo_Operacion) {
                case Tipo_Operacion.INSERTAR ->
                    sql = this.generarSQLParaInsercion();
                case Tipo_Operacion.MODIFICAR ->
                    sql = this.generarSQLParaModificacion();
                case Tipo_Operacion.ELIMINAR ->
                    sql = this.generarSQLParaEliminacion();
            }
            this.colocarSQLenStatement(sql);
            switch (tipo_Operacion) {
                case Tipo_Operacion.INSERTAR ->
                    this.incluirValorDeParametrosParaInsercion();
                case Tipo_Operacion.MODIFICAR ->
                    this.incluirValorDeParametrosParaModificacion();
                case Tipo_Operacion.ELIMINAR ->
                    this.incluirValorDeParametrosParaEliminacion();
            }
            resultado = this.ejecutarModificacionEnBD(sql);
            if (this.retornarLlavePrimaria) {
                Integer id = this.retornarUltimoAutoGenerado();
                resultado = id;
            }
            if (this.usarTransaccion) {
                this.comitarTransaccion();
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar ejecutar el comando SQL - " + ex);
            if (this.usarTransaccion) {
                try {
                    this.rollbackTransaccion();
                } catch (SQLException ex1) {
                    System.err.println("Error al intentar hacer rollback - " + ex);
                }
            }
        } finally {
            try {
                if (this.usarTransaccion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }

        }
        this.tipo_Operacion = null;
        return resultado;
    }

    protected Integer insertar() {
        return this.ejecuta_DML(Tipo_Operacion.INSERTAR);
    }

    protected String generarSQLParaInsercion() {
        String sql = "insert into ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" (");
        sql = sql.concat(this.obtenerListaDeAtributosParaInsercion());
        sql = sql.concat(") values (");
        sql = sql.concat(this.incluirListaDeParametrosParaInsercion());
        sql = sql.concat(")");
        return sql;
    }

    protected abstract String obtenerListaDeAtributosParaInsercion();

    protected abstract String incluirListaDeParametrosParaInsercion();

    protected abstract void incluirValorDeParametrosParaInsercion() throws SQLException;

    protected Integer modificar() {
        return this.ejecuta_DML(Tipo_Operacion.MODIFICAR);
    }

    protected String generarSQLParaModificacion() {
        String sql = "update ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" set ");
        sql = sql.concat(this.obtenerListaDeValoresYAtributosParaModificacion());
        sql = sql.concat(" ");
        sql = sql.concat("where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    protected abstract String obtenerListaDeValoresYAtributosParaModificacion();

    protected abstract String obtenerPredicadoParaLlavePrimaria();

    protected abstract void incluirValorDeParametrosParaModificacion() throws SQLException;

    protected Integer eliminar() {
        return this.ejecuta_DML(Tipo_Operacion.ELIMINAR);
    }

    private String generarSQLParaEliminacion() {
        String sql = "update ";
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(" set activo=0");
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    protected abstract void incluirValorDeParametrosParaEliminacion() throws SQLException;

    public List listarTodos(Integer limite) {
        List lista = new ArrayList<>();
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarTodos(limite);
            this.colocarSQLenStatement(sql);
            this.incluirValorDeParametrosParaListado();
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                agregarObjetoALaLista(lista, this.resultSet);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return lista;
    }

    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla);
        sql = sql.concat(this.obtenerPredicadoParaListado());
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    protected abstract String obtenerProyeccionParaSelect();

    protected String obtenerPredicadoParaListado() {
        return " where activo=1 ";
    }

    protected void incluirValorDeParametrosParaListado() throws SQLException {
        //por defecto no se incluye ningún parametro para el listado
        //de esta forma se mantiente el comportamiento de los listarTodos()
    }

    protected abstract void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException;

    public void obtenerPorId() {
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarPorId();
            this.colocarSQLenStatement(sql);
            this.incluirValorDeParametrosParaObtenerPorId();
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
            } else {
                limpiarObjetoDelResultSet();
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
    }
    
    public void obtenerPorNombre() {
        try {
            this.abrirConexion();
            String sql = this.generarSQLParaListarPorId();
            this.colocarSQLenStatement(sql);
            this.incluirValorDeParametrosParaObtenerPorId();
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                instanciarObjetoDelResultSet();
            } else {
                limpiarObjetoDelResultSet();
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
    }
    protected String generarSQLParaListarPorNombre() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla);
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(this.obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla);
        sql = sql.concat(" where ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    protected abstract void incluirValorDeParametrosParaObtenerPorId() throws SQLException;

    protected abstract void instanciarObjetoDelResultSet() throws SQLException;

    protected abstract void limpiarObjetoDelResultSet();

    /* Los siguientes métodos:
        - ObtenerFechaParaSQL
        - ObtenerStringParaSQL
        - ObtenerIntegerParaSQL
        - ObtenerBooleanParaSQL
        fueron usados en la versión de la clase en donde se trabajaba con un statement
        razón por la cual era necesario que se manejase la nulidad en el comando SQL.
        La actual versión de esta clase implementa el manejo de parámetros a través de los
        métodos:
        - incluirParametroString
        - incluirParametroInt
        - incluirParametroDate
        - incluirParametroBoolean
     */
    protected String ObtenerFechaParaSQL(Date fecha) {
        String sql = "NULL";
        if (fecha != null) {
            sql = "STR_TO_DATE";
            sql = sql.concat("(");
            sql = sql.concat("'");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            Integer anho = calendar.get(Calendar.YEAR);
            Integer mes = calendar.get(Calendar.MONTH) + 1;
            Integer dia = calendar.get(Calendar.DAY_OF_MONTH);
            Integer hora = calendar.get(Calendar.HOUR_OF_DAY);
            Integer minuto = calendar.get(Calendar.MINUTE);
            Integer segundo = calendar.get(Calendar.SECOND);

            sql = sql.concat(anho.toString());
            sql = sql.concat("/");
            sql = sql.concat(String.format("%02d", mes));
            sql = sql.concat("/");
            sql = sql.concat(String.format("%02d", dia));
            sql = sql.concat(" ");
            sql = sql.concat(String.format("%02d", hora));
            sql = sql.concat(":");
            sql = sql.concat(String.format("%02d", minuto));
            sql = sql.concat(":");
            sql = sql.concat(String.format("%02d", segundo));

            sql = sql.concat("', ");
            sql = sql.concat("'");
            sql = sql.concat("%Y/%m/%d %H:%i:%S");
            sql = sql.concat("'");
            sql = sql.concat(")");
        }
        return sql;
    }

    protected String ObtenerStringParaSQL(String valor) {
        String sql = "NULL";
        if (valor != null) {
            sql = "'";
            sql = sql.concat(valor);
            sql = sql.concat("'");
        }
        return sql;
    }

    protected String ObtenerIntegerParaSQL(Integer valor) {
        String sql = "NULL";
        if (valor != null) {
            sql = valor.toString();
        }
        return sql;
    }

    protected String ObtenerBooleanParaSQL(Boolean valor) {
        String sql = "NULL";
        if (valor != null) {
            if (valor) {
                sql = "1";
            } else {
                sql = "0";
            }
        }
        return sql;
    }

    //No se abre ni se cierra conexión pues este método siempre será ejecutado en un insert
    public Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        try {
            String sql = "select @@last_insert_id as id";
            this.colocarSQLenStatement(sql);
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar retornarUltimoAutoGenerado - " + ex);
        }
        return resultado;
    }

    protected void incluirParametroString(Integer numeroParametro, String valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.VARCHAR);
        } else {
            this.statement.setString(numeroParametro, valor);
        }
    }

    protected void incluirParametroInt(Integer numeroParametro, Integer valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.INTEGER);
        } else {
            this.statement.setInt(numeroParametro, valor);
        }
    }
    
    protected void incluirParametroDouble(Integer numeroParametro, Double valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.DOUBLE);
        } else {
            this.statement.setDouble(numeroParametro, valor);
        }
    }


    protected void incluirParametroDate(Integer numeroParametro, Date valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.DATE);
        } else {
            java.sql.Date sqlDate = new java.sql.Date(valor.getTime());
            this.statement.setDate(numeroParametro, sqlDate);
        }
    }

    protected void incluirParametroBoolean(Integer numeroParametro, Boolean valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(numeroParametro, Types.BOOLEAN);
        } else {
            this.statement.setBoolean(numeroParametro, valor);
        }
    }

    protected void incluirParametroString(String nombreParametro, String valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.VARCHAR);
        } else {
            this.statement.setString(nombreParametro, valor);
        }
    }

    protected void incluirParametroInt(String nombreParametro, Integer valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.INTEGER);
        } else {
            this.statement.setInt(nombreParametro, valor);
        }
    }
    
    protected void incluirParametroDouble(String nombreParametro, Double valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.DOUBLE);
        } else {
            this.statement.setDouble(nombreParametro, valor);
        }
    }

    protected void incluirParametroDate(String nombreParametro, Date valor) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(valor.getTime());
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.DATE);
        } else {
            this.statement.setDate(nombreParametro, sqlDate);
        }
    }

    protected void incluirParametroBoolean(String nombreParametro, Boolean valor) throws SQLException {
        if (valor == null) {
            this.statement.setNull(nombreParametro, Types.BOOLEAN);
        } else {
            this.statement.setBoolean(nombreParametro, valor);
        }
    }
    
    protected void incluirParametroFoto(Integer numeroParametro, Byte[] foto) throws SQLException {
        if (foto == null) {
            this.statement.setNull(numeroParametro, Types.BLOB);  // Asigna valor nulo si no hay foto
        } else {
            this.statement.setBytes(numeroParametro, convertirByteArrayABytes(foto));  // Convierte Byte[] a byte[]
        }
    }

    protected byte[] convertirByteArrayABytes(Byte[] byteArray) {
        byte[] bytes = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            bytes[i] = byteArray[i];  // Copia cada valor Byte a su equivalente primitivo byte
        }
        return bytes;
    }
    
    protected Byte[] convertirBytesAByteArray(byte[] bytes) {
        Byte[] byteArray = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            byteArray[i] = bytes[i];  // Convierte cada byte primitivo en Byte
        }
        return byteArray;
    }

}
    
