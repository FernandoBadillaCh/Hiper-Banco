package org.example;

import javax.swing.JOptionPane;

public class Cliente {

    private String nombre;
    private String idcliente;
    private String telefono;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;
    private int TarjetaAcceso[][];
    private Cuenta cuentas[];

    //***********************************************************************Contructor***********************************************************************//
    public Cliente() {
        this.nombre = "";
        this.idcliente = "";
        this.correo = "";
        this.usuario = "";
        this.telefono = "";
        this.clave = "";
        this.estado = "Activo";
        this.cuentas = new Cuenta[5];
        this.TarjetaAcceso = new int[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                this.TarjetaAcceso[i][j] = Numerosaleatorios(10, 99);
            }
        }
    }

    public Cliente(String nombre, String idcliente, String telefono, String correo, String usuario, String clave, int[][] TarjetaAcceso) {
        this.nombre = nombre;
        this.idcliente = idcliente;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = "Activo";
        this.cuentas = new Cuenta[5];
        this.TarjetaAcceso = new int[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                this.TarjetaAcceso[i][j] = Numerosaleatorios(10, 99);
            }
        }
    }

    //*************************************************************************Metodos**************************************************************************//
    public int Numerosaleatorios(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public String MostrarClavedinamica() {
        String claveD = "Tarjeta de acceso     |A|       |B|       |C|       |D|       |E|\n";
        for (int i = 0; i < 4; i++) {
            claveD += "      " + (i + 1) + "      ";
            claveD += "      ";
            for (int j = 0; j < 5; j++) {

                claveD += "   |" + this.TarjetaAcceso[i][j] + "|   ";
            }
            claveD += "\n";
        }
        return claveD;
    }

    public void mostrarTodasLasCuentas() {
        for (int i = 0; i < GetindexCuenta(); i++) {
            System.out.println("Número de cuenta: " + cuentas[i].getNumerodecuenta()
                    + ", saldo: " + cuentas[i].getSaldo()
                    + ", fecha: " + cuentas[i].getFecha()
                    + ", tipo: " + cuentas[i].getTipo());
        }
    }

    public int GetindexCuenta() {
        for (int i = 0; i < 5; i++) {
            if (this.cuentas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void agregarCuenta(Cuenta cuenta) {
        int index = GetindexCuenta();
        this.cuentas[index] = cuenta;
    }

    public Cuenta Buscarcuentageneral(int num) {

        for (int i = 0; i < GetindexCuenta(); i++) {
            if (num == cuentas[i].getNumerodecuenta()) {
                return cuentas[i];
            }
        }
        return null;
    }

    public Cuenta Buscarcuentacliente() {
        for (int i = 0; i < GetindexCuenta(); i++) {
            if (cuentas[i] != null) {
                return cuentas[i];
            }
        }
        return null;
    }

    public int[] Getnumerosdecuentacliente() {
        int[] cuentascliente = new int[GetindexCuenta()];

        for (int i = 0; i < GetindexCuenta(); i++) {
            cuentascliente[i] = this.cuentas[i].getNumerodecuenta();
        }
        return cuentascliente;
    }

    //*******************************************************************Setters and Getters*******************************************************************//
    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setIDcliente(String id) {
        this.idcliente = id;
    }

    public String getIDcliente() {
        return this.idcliente;
    }

    public void setTelefono(String telefono) {

        boolean verificar = verificarTelefono(telefono);

        if (verificar == true) {

            this.telefono = telefono;

        } else {

            boolean esTelefonoValido = false;

            // Ciclo para solicitar al usuario que ingrese un número de teléfono válido
            while (esTelefonoValido == false) {
                String telefonoIngresado = JOptionPane.showInputDialog("Ingrese su número de teléfono, el formato a seguir es (XXXX-XXXX)");

                // Verificar si el número de teléfono es válido
                esTelefonoValido = verificarTelefono(telefonoIngresado);
                if (esTelefonoValido == false) {
                    JOptionPane.showMessageDialog(null, "El número de teléfono es inválido. Asegúrese de ingresar un número en el formato XXXX-XXXX sin letras.");
                } else {
                    this.telefono = telefonoIngresado;
                    JOptionPane.showMessageDialog(null, "Número registrado correctamente");
                    break;
                }
            }
        }
    }

    public String getTelefono() {
        String codigo = "+506 ";
        return codigo + this.telefono;
    }

    public void setCorreo(String correo) {

        boolean verificar = verificarCorreo(correo);

        if (verificar == true) {
            this.correo = correo;

        } else {
            boolean CorreoValido = false;

            while (CorreoValido == false) {
                String correoIngresado = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
                if (correoIngresado.contains("@")) {
                    String subCorreo = correoIngresado.substring(correoIngresado.indexOf('@'));
                    if (subCorreo.contains(".")) {
                        this.correo = correoIngresado;
                        CorreoValido = true;
                        JOptionPane.showMessageDialog(null, "Correo electrónico registrado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "El correo electrónico ingresado es inválido. Asegúrese de ingresar un correo electrónico con formato válido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico ingresado es inválido. Asegúrese de ingresar un correo electrónico con formato válido.");
                }
            }
        }
    }

    public String getCorreo() {
        if (this.correo != null) {
            return this.correo.substring(0, 6)
                    + "*****"
                    + this.correo.substring(this.correo
                    .indexOf('@'));
        } else {
            return "Sin correo asignado";
        }
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return this.clave;
    }

    public String getClaveOculta() {
        String asteriscos = "";
        for (int i = 0; i < this.clave.length(); i++) {
            asteriscos += "*";
        }
        return asteriscos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public int[][] getTarjetaAcceso() {
        return TarjetaAcceso;
    }

    public void setTarjetaAcceso(int[][] TarjetaAcceso) {
        this.TarjetaAcceso = TarjetaAcceso;
    }

    //*************************************************************************Metodos para los atributos**************************************************************************//
    public boolean verificarTelefono(String telefono) {

        if (telefono.length() == 9) {
            // Verificar si el número de teléfono es válido
            String T1 = telefono.substring(0, 3);
            String T2 = telefono.substring(5, 8);
            boolean T11 = esNumerico(T1);
            boolean T22 = esNumerico(T2);
            int guion = telefono.indexOf("-");

            if (T11 == true && T22 == true) {
                if (guion == 4) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean verificarCorreo(String correo) {
        if (correo.contains("@")) {
            String subCorreo = correo.substring(correo.indexOf('@'));
            if (subCorreo.contains(".")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean esNumerico(String telefono) {
        try {
            Integer.parseInt(telefono);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
