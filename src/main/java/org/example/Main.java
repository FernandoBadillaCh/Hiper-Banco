package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int generado = 0;

        Cliente clientes[] = new Cliente[30];
        Cuenta cuentas[] = new Cuenta[150];


        while (true) {
            int opcionP = MenuPrincipal();

//        MenuBanco
            switch (opcionP) {
                //
                case 0:
                    while (true) {
                        int opcion = MenuBanco();

                        switch (opcion) {
                            case 1://Generar datos

                                if (generado == 0) {
                                    generado++;
                                    Generardatos(clientes, cuentas);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Datos Generados anteriormente");
                                }

                                break;

                            case 2://Mostrar Clientes
                                if (Hayclientesgenerados(clientes) == true) {
                                    Mostrarclientes(clientes);
                                }

                                break;

                            case 3://Mostrar cuentas y movimientos
                                if (Hayclientesgenerados(clientes) == true) {
                                    MostrarCuentasyMovimientos(clientes, cuentas);
                                }
                                break;

                            case 4://Agregar nuevo cliente
                                Agregarnuevocliente(clientes);
                                break;

                            case 5://Agregar nueva cuenta
                                if (Hayclientesgenerados(clientes) == true) {
                                    Agregarnuevacuenta(clientes, cuentas);
                                }
                                break;
                            case 6://Buscar Cliente
                                if (Hayclientesgenerados(clientes) == true) {
                                    Buscarcliente(clientes);
                                }
                                break;

                            case 7://Buscar Cuenta
                                if (Hayclientesgenerados(clientes) == true) {
                                    Buscarcuenta(clientes, 0);
                                }
                                break;

                            case 8://Generar reportes
                                if (Hayclientesgenerados(clientes) == true) {
                                    GenerarReportes(clientes, cuentas);
                                }

                                break;

                            case 9://Salir al menu bancario

                                break;

                            default:
                                break;

                        }

                        if (opcion == 9) {
                            break;
                        }

                    }
                    break;
                //
                case 1:
                    if (clientes[0] == null) {
                        JOptionPane.showMessageDialog(null, "No hay clientes registrados");
                        break;
                    }

                    Cliente usuario = Login(clientes);

                    if (usuario == null) {
                        break;
                    }
                    while (true) {

                        int opcion = MenuCliente();
                        switch (opcion) {
                            case 0://Realizar transaccion
                                RealizarTransaccion(clientes, usuario, cuentas);
                                break;
                            case 1:// Miscuentas
                                MisCuentas(usuario, cuentas);
                                break;
                            case 2:// Actualizar
                                ActualizarMC(usuario, clientes);
                                break;
                            case 3:// Salir

                                JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
                                break;

                        }
                        if (opcion == 3) {
                            break;
                        }
                    }
                    break;

                case 2:// saliendo del sistema
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema\nGracias por la preferencia");
                    break;
                default:

                    break;
            }
            if (opcionP == 2) {
                break;
            }
        }

    }
//**************************************** Botones de los menus principales **********************************************************
///

    public static int MenuPrincipal() {
        String OpcionMenuP[] = {"Banco", "Clientes", "Salir"};
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opcion",
                "Bienvenido a HiperBanco",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                OpcionMenuP,
                "Banco");
    }

    public static int MenuBanco() {
        int OpcionMenuB = Integer.parseInt(JOptionPane.showInputDialog("Menu Bancario" + "\n1. Generar Datos\n" + "2. Mostrar Clientes\n" + "3. Mostrar Cuentas y Movimientos\n" + "4. Agregar Nuevo Cliente\n"
                + "5. Agregar Nueva Cuenta\n" + "6. Buscar Cliente\n" + "7. Buscar Cuenta\n" + "8. Generar Reportes\n" + "9. Salir del Sistema Bacario\n"));
        return OpcionMenuB;

    }

    public static int MenuCliente() {
        String OpcionMenuC[] = {"Realizar Transaccion", "Mis cuentas", "Actualizar", "Salir"};
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opcion del sistema",
                "Bienvenido",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                OpcionMenuC,
                "Realizar Transaccion");
    }

    //**********************************************Opciones del menu Banco **************************************************************
///
    public static void Generardatos(Cliente clientes[], Cuenta cuentas[]) {

        String[] nombres = {"Pedro Gonzalez Huertas", "Tamara Fernandez Gamboa", "Jose Montiel Sanchez",
                "Elizabeth Mora Barrantes", "Marco Navarro Mora", "Ruth Alvarado Fallas",
                "Jeremy Vargas Jimenez", "Steven Sanchez Hernandez", "Kimberly Ramirez Castro",
                "Daniel Lopez Araya", "Michelle Morales Campos", "Esteban Campos Vega",
                "Graciela Chavarria Alvarez", "Ingrid Espinoza Salas", "Freddy Cordero Soto"};

        String[] id = {"1-1852-3695", "3-2540-2589", "2-0325-0255",
                "9-3225-8745", "1-1705-0275", "6-2541-9856",
                "4-5210-6586", "3-1254-9569", "5-3251-5623",
                "1-1705-0276", "7-1011-5695", "7-0420-0953",
                "6-6595-9861", "1-2536-5869", "1-2345-6789",};

        String[] telefono = {"8653-2514", "7215-5692", "8412-5610",
                "7158-2165", "8875-6341", "8462-7412",
                "2512-5469", "8451-5264", "8698-7401",
                "2410-9865", "2287-8710", "8896-5964",
                "2512-5112", "8888-8888", "8965-1425",};

        String[] correos = {"Pgonzalez3695@gmail.com", "Tfernandez2589@outlook.com", "Jmontiel0255@yahoo.com",
                "Emora8745@gmail.com", "Mnavarro5569@hotmail.com", "Ralvarado9856@hotamil.com",
                "Jvargas6586@gmail.com", "Ssanchez9569@gmail.com", "Kramirez5623@yahoo.com",
                "Dlopez1254@outlook.es", "Mmorales5695@gmail.com", "Ecampos0953@hotmail.com",
                "Gchavarria9861@outlook.com", "Iespinoza5869@yahoo.com", "Fcordero1254@gmail.com"};

        for (int i = 0; i < 15; i++) {
            int index = Getindex(clientes);
            clientes[index] = new Cliente();
            clientes[index].setNombre(nombres[i]);
            clientes[index].setIDcliente(id[i]);
            clientes[index].setTelefono(telefono[i]);
            clientes[index].setCorreo(correos[i]);

            String Usuario = nombres[i];

            int espacio = Usuario.indexOf(" ");
            String NombreUsuario = Usuario.substring(0, espacio);

            clientes[index].setUsuario(NombreUsuario + (40 + index));
            clientes[index].setClave("123456a");

        }

//        ******************************************************cuentas*******************************************
        int contadorcuentas = 0;
        for (int i = 0; i < 17; i++) {

            double saldo = Numerosaleatorios(100000, 500000);
            int TipoaleatorioC = Numerosaleatorios(0, 4);
            int aleatoriocuenta = Numerosaleatorios(1, 14);
            TipoCuenta TipoC = TipoCuenta.Corriente;

            if (TipoaleatorioC == 0) {
                TipoC = TipoCuenta.Corriente;
            }
            if (TipoaleatorioC == 1) {
                TipoC = TipoCuenta.Ahorros;
            }
            if (TipoaleatorioC == 2) {
                TipoC = TipoCuenta.Inversión;
            }
            if (TipoaleatorioC == 3) {
                TipoC = TipoCuenta.Planilla;
            }

            contadorcuentas++;
            if (contadorcuentas == 14) {
                contadorcuentas = aleatoriocuenta;
            }

            Cuenta cuentaprovisional = new Cuenta(saldo, TipoC);
            clientes[contadorcuentas].agregarCuenta(cuentaprovisional);
            cuentas[i] = cuentaprovisional;

//            ***********************************transacciones*******************************************
            int cantidadTransacciones = Numerosaleatorios(0, 6);

            for (int j = 0; j < cantidadTransacciones; j++) {
                int TipoaleatorioT = Numerosaleatorios(0, 4);
                double monto = Numerosaleatorios(1000, 25000);
                int cantidadcuentas = GetindexCuentaArreglo(cuentas);
                int transferenciacuentaaleatorio = Numerosaleatorios(0, cantidadcuentas);
                int detallealeatorio = Numerosaleatorios(0, 50);
                String[] detalle = {"Libro electrónico", "Tablet", "Smartphone", "Laptop", "Auriculares inalámbricos", "Smartwatch", "Cámara digital", "Altavoz Bluetooth", "Consola de videojuegos", "Monitor de computadora", "Disco duro externo", "Memoria USB", "Impresora", "Teclado inalámbrico", "Mouse inalámbrico", "Tarjeta de memoria", "Micrófono USB", "Bocina inteligente", "Aparato de fitness", "Dron", "Cámara de seguridad", "Reloj inteligente", "Aspiradora robot", "Proyector", "Reproductor de streaming", "Barra de sonido", "Audífonos con cancelación de ruido", "Monitor de bebé", "Máquina de café", "Robot de cocina", "Licuadora", "Batidora", "Plancha de ropa", "Cepillo de dientes eléctrico", "Cortadora de cabello", "Máquina de afeitar eléctrica", "Secadora de cabello", "Plancha de pelo", "Rizador de pelo", "Funda para celular", "Protector de pantalla", "Cargador inalámbrico", "Soporte para celular en el coche", "Estuche para laptop", "Mochila para laptop", "Candado para laptop", "Base de enfriamiento para laptop", "Luz LED para monitor de computadora", "Hub USB", "Adaptador HDMI"};

                TipoTransaccion TipoT = TipoTransaccion.Compra;

                if (TipoaleatorioT == 0) {
                    TipoT = TipoTransaccion.Compra;
                }
                if (TipoaleatorioT == 1) {
                    TipoT = TipoTransaccion.Deposito;
                }
                if (TipoaleatorioT == 2) {
                    TipoT = TipoTransaccion.Retiro;
                }
                if (TipoaleatorioT == 3) {
                    TipoT = TipoTransaccion.Transferencia;
                }

                if (TipoT == TipoTransaccion.Compra) {
                    cuentaprovisional.RealizarCompraonline(cuentaprovisional, detalle[detallealeatorio], monto);
                }

                if (TipoT == TipoTransaccion.Deposito || TipoT == TipoTransaccion.Retiro) {
                    cuentaprovisional.RealizarDepositoRetiro(cuentaprovisional, TipoT, monto);
                }

                if (TipoT == TipoTransaccion.Transferencia) {

                    if (cuentaprovisional.getNumerodecuenta() != cuentas[transferenciacuentaaleatorio].getNumerodecuenta()) {

                        cuentaprovisional.RealizarTranferencia(cuentaprovisional, cuentas[transferenciacuentaaleatorio], monto);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Datos generados con exito");

    }

    public static void Mostrarclientes(Cliente clientes[]) {

        int index = Getindex(clientes);

        for (int i = 0; i < index; i++) {

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("          Cliente #" + (i + 1) + "          ");
            System.out.println("\n Nombre: " + clientes[i].getNombre()
                    + "\n Identificacion: " + clientes[i].getIDcliente()
                    + "\n Telefono: " + clientes[i].getTelefono()
                    + "\n Correo Elcetronico: " + clientes[i].getCorreo()
                    + "\n Usuario: " + clientes[i].getUsuario()
                    + "\n Contraseña: " + clientes[i].getClave()
                    + "\n Estado: " + clientes[i].getEstado()
                    + "\n Clave dinamica: " + clientes[i].MostrarClavedinamica());
        }

    }

    public static void MostrarCuentasyMovimientos(Cliente[] clientes, Cuenta cuentas[]) {

        for (int i = 0; i < GetindexCuentaArreglo(cuentas); i++) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Numero cuenta " + cuentas[i].getNumerodecuenta() + "\nSaldo: " + cuentas[i].getSaldo() + "\nTipo de cuenta: " + cuentas[i].getTipo() + "\nFecha de apertura: " + cuentas[i].getFecha());
            System.out.println("Movimientos:\n");
            System.out.println(cuentas[i].mostrarTodasLasTransacciones());
            System.out.println("");
        }

    }

    public static void Agregarnuevocliente(Cliente clientes[]) {
        int vacio = Getindex(clientes);
        clientes[vacio] = new Cliente();

        boolean Saliralmenu = false;
        while (!Saliralmenu) {
            int saliropcion = 0;

            boolean Existeid = false;
            while (!Existeid) {

                String id = verificarID(clientes);

                if (id == null) {
                    String OpcionMenuC[] = {"Agregar otro ID", "Cancelar"};
                    int opc = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Cliente ya registrado", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OpcionMenuC, "Agregar otro ID");

                    if (opc == 0) {

                    } else {
                        saliropcion = 1;
                        clientes[vacio] = null;
                    }
                } else {
                    clientes[vacio].setIDcliente(id);
                    Existeid = true;
                }
            }

            if (saliropcion == 1) {
                break;
            }
            String nombre = JOptionPane.showInputDialog("Digite su nombre completo");
            clientes[vacio].setNombre(nombre);
            clientes[vacio].setTelefono(JOptionPane.showInputDialog("Digite su numero telefonico siguiendo el fomato XXXX-XXXX"));

            boolean ValidarCorreo = false;
            while (!ValidarCorreo) {

                String correo = JOptionPane.showInputDialog("Digite su correo");

                boolean formato = verificarCorreo(correo);

                if (formato == false) {
                    String OpcionMenuC[] = {"Agregar otro correo", "Cancelar"};
                    int opc = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Correo incorrecto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OpcionMenuC, "Agregar otro correo");

                    if (opc == 0) {

                    } else {
                        saliropcion = 1;
                        clientes[vacio] = null;
                        ValidarCorreo = true;
                    }
                } else {
                    clientes[vacio].setCorreo(correo);
                    ValidarCorreo = true;
                }
            }

            if (saliropcion == 1) {
                break;
            }
            int espacio = nombre.indexOf(" ");
            String NombreUsuario = nombre.substring(0, espacio);
            clientes[vacio].setUsuario(NombreUsuario + (40 + vacio));

            JOptionPane.showMessageDialog(null, ("Usuario creado con exito\n\n" + "Nombre: " + clientes[vacio].getNombre() + "\nIdentificacion:  " + clientes[vacio].getIDcliente()
                    + "\nTelefono:   " + clientes[vacio].getTelefono() + "\nCorreo:   " + clientes[vacio].getCorreo() + "\nUsuario: " + clientes[vacio].getUsuario()));

            Saliralmenu = true;
        }
    }

    public static void Agregarnuevacuenta(Cliente clientes[], Cuenta cuentas[]) {

        int id = BuscarID(clientes);
        int index = GetindexCuentaArreglo(cuentas);
        if (id != -1) {
            int idcuenta = clientes[id].GetindexCuenta();
            if (idcuenta != -1) {

                TipoCuenta Tipo = Tipocuenta();
                double saldo = Saldocuenta();

                if (saldo == -1) {
                    return;
                }

                Cuenta Cuentanueva = new Cuenta(saldo, Tipo);

                JOptionPane.showMessageDialog(null, "Cuenta registrada con exito" + "\nCliente: " + clientes[id].getNombre() + "\nIdentificacion: " + clientes[id].getIDcliente() + "\nCuenta: " + Cuentanueva.getNumerodecuenta() + "\nTipo: " + Cuentanueva.getTipo() + "\nSaldo: " + Cuentanueva.getSaldo() + "\nFecha de apertura: "
                        + Cuentanueva.getFecha());


                cuentas[index] = Cuentanueva;
                clientes[id].agregarCuenta(Cuentanueva);

            } else {
                int opt = MenuBotones("Cliente ya tiene 5 cuentas", "Cuentas maximas permitidas", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro id", "Cancelar"});

                if (opt == 0) {
                    Agregarnuevacuenta(clientes, cuentas);
                } else {
                }
            }
        } else {
            int opt = MenuBotones("Cliente no encontrado", "ID no valida", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro id", "Cancelar"});

            if (opt == 0) {
                Agregarnuevacuenta(clientes, cuentas);
            } else {
            }
        }

    }

    public static void Buscarcliente(Cliente clientes[]) {

        int id = BuscarID(clientes);

        if (id != -1) {
            Mostrar1cliente(clientes, id);
            int opt = MenuBotones("Opciones", "Opciones", JOptionPane.QUESTION_MESSAGE, new String[]{"Actualizar", "Activar-Desactivar", "Botones de cuenta", "Salir"});

            switch (opt) {
                case 0://Actualizar
                    Actualizar(clientes, id);
                    break;

                case 1://Activar-Desactivar
                    ActivarDesactivar(clientes, id);
                    break;

                case 2://Botones de cuentas
                    int cuentaBC = mostrarBotonesCuentas(clientes, id);
                    Buscarcuenta(clientes, cuentaBC);
                    break;

                case 3://Cancelar

                    break;

                default:
                    throw new AssertionError();
            }

        } else {
            int opt = MenuBotones("Cliente no encontrado", "ID no valida", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro id", "Cancelar"});

            if (opt == 0) {
                Buscarcliente(clientes);
            }

        }
    }

    public static void Buscarcuenta(Cliente clientes[], int cuentaBC) {

        int cuenta = 0;
        if (cuentaBC != 0) {
            cuenta = cuentaBC;
        } else {
            int cuentaingresada = Integer.parseInt(JOptionPane.showInputDialog("Digite la cuenta a buscar"));
            cuenta = cuentaingresada;
        }

        int noencontrada = 0;

        for (int i = 0; i < Getindex(clientes); i++) {
            Cuenta cuentaencontrada = clientes[i].Buscarcuentageneral(cuenta);

            if (cuentaencontrada == null) {
                noencontrada++;

            } else {

                JOptionPane.showMessageDialog(null, "Titular de la cuenta: " + clientes[i].getNombre() + "\nNumero de cuenta: " + cuentaencontrada.getNumerodecuenta()
                        + "\nSaldo: " + cuentaencontrada.getSaldo() + "\nTipo de cuenta: " + cuentaencontrada.getTipo() + "\nFecha de creacion: " + cuentaencontrada.getFecha());

                int opt = MenuBotones("Cuenta " + cuenta, "Cuenta encontrada", JOptionPane.WARNING_MESSAGE, new String[]{"Movimientos", "Cancelar"});
                if (opt == 0) {
                    ///movimientos
                    System.out.println(cuentaencontrada.mostrarTodasLasTransacciones());
                }

            }
        }

        if (noencontrada == Getindex(clientes)) {
            System.out.println("");
            int opt = MenuBotones("Cuenta # " + cuenta + " no registrada en el sistema", "Cuenta no encontrada", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro numero de cuenta", "Cancelar"});
            if (opt == 0) {
                Buscarcuenta(clientes, 0);
            }
        }

    }

    public static void GenerarReportes(Cliente clientes[], Cuenta cuentas[]) {

        String id = "Todos";
        String estado = "Todos";
        TipoCuenta tipocuenta = TipoCuenta.Todas;
        Double saldo = 0.0;
        int idX = -1;

        String Filtros = "Filtro Cliente                              Filtro Cuenta\n"
                + "ID del cliente: " + id + "                  Tipo de cuenta: " + tipocuenta + "\n"
                + "Estado: " + estado + "                    Saldo: " + saldo;

        while (true) {

            int opt = MenuBotones("Seleccione una opcion", "Menu", JOptionPane.DEFAULT_OPTION, new String[]{"Filtros de cliente", "Filtros de cuenta", "Reporte", "Salir"});

            switch (opt) {
                case 0:////////////////////////////////////////////////////////////////////////Filtro Cliente///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    idX = BuscarID(clientes);

                    if (idX == -1) {
                        id = "Todos";
                    } else {
                        id = clientes[idX].getIDcliente();
                    }

                    int optEstado = MenuBotones("Estado del filtro", "Menu", JOptionPane.DEFAULT_OPTION, new String[]{"Activo", "Desactivo", "Todos"});

                    switch (optEstado) {
                        case 0:
                            estado = "Activo";
                            break;
                        case 1:
                            estado = "Desactivo";
                            break;
                        case 2:
                            estado = "Todos";
                            break;
                        default:
                            throw new AssertionError();
                    }
                    Filtros = "Filtro Cliente                              Filtro Cuenta\n"
                            + "ID del cliente: " + id + "         Tipo de cuenta: " + tipocuenta + "\n"
                            + "Estado: " + estado + "                         Saldo: " + saldo;

                    JOptionPane.showMessageDialog(null, Filtros);

                    break;
                case 1:///////////////////////////////////////////////////////////////////////Filtro cuenta///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    tipocuenta = TipocuentaGenerarReportes();

                    double saldoingresado = Double.parseDouble(JOptionPane.showInputDialog("Digite el saldo"));

                    int optsaldo = MenuBotones("Saldo", "Menu", JOptionPane.DEFAULT_OPTION, new String[]{"Mayor", "Menor", "Todos"});

                    if (optsaldo == 0) {

                        saldo = saldoingresado;

                    }
                    if (optsaldo == 1) {
                        saldo = -saldoingresado;

                    }
                    if (optsaldo == 2) {

                        saldo = 0.0;

                    }

                    Filtros = "Filtro Cliente                              Filtro Cuenta\n"
                            + "ID del cliente: " + id + "         Tipo de cuenta: " + tipocuenta + "\n"
                            + "Estado: " + estado + "                         Saldo: " + saldo;

                    JOptionPane.showMessageDialog(null, Filtros);

                    break;
                case 2:///////////////////////////////////////////////////////////////////////Reporte///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                case 3:///////////////////////////////////////////////////////////////////////Salir///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    JOptionPane.showMessageDialog(null, "Saliendo al menu principal");
                    break;
                default:
                    throw new AssertionError();

            }
            if (opt == 3) {
                break;
            }

        }

    }

    //********************************************** Opciones del menu Cliente *************************************************************
///
    public static Cliente Login(Cliente clientes[]) {
        String estado = "Activo";
        String usuarioingresado = JOptionPane.showInputDialog("Ingrese su usuario");

        int Xusuario = BuscarUsuario(clientes, usuarioingresado);

        if (Xusuario == -1) {
            int opt = MenuBotones("Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE, new String[]{"Ingresar otro usuario", "Cancelar"});
            if (opt == 0) {
                Login(clientes);
            } else {
                return null;
            }
        }
        Cliente clienteingresando = clientes[Xusuario];

        if (usuarioingresado.equals(clienteingresando.getUsuario())) {
            if (estado.equals(clienteingresando.getEstado())) {
                if (clienteingresando.getClave().equals("")) {
                    // usuario nuevo
                    String contrasena = DefinirContrasena(clientes);

                    if (contrasena != null) {
                        clienteingresando.setClave(contrasena);
                        JOptionPane.showMessageDialog(null, "Contraseña guardada correctamente");
                        Login(clientes);
                    } else {
                        return null;
                    }
                } else {
                    // usuario ya registrado anteriormente
                    int intentosFallidos = 0;

                    while (intentosFallidos < 3) {
                        String contrasena = JOptionPane.showInputDialog("Digite su contraseña");
                        String contrasenausuario = clienteingresando.getClave();

                        if (contrasena.equals(contrasenausuario)) {
                            boolean acceso = Acessoclavedinamica(clienteingresando);

                            if (acceso == true) {
                                return clienteingresando;
                            } else {
                                int opt = MenuBotones("No posible entrar sin clave dinamica", "Menu", JOptionPane.ERROR_MESSAGE, new String[]{"Intentar logear nuevamente", "ir al Menu Principal"});
                                if (opt == 0) {
                                    intentosFallidos++;
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                            intentosFallidos++;
                        }
                    }

                    // Desactivar cliente después de 3 intentos fallidos
                    clienteingresando.setEstado("Inactivo");
                    JOptionPane.showMessageDialog(null, "Se ha desactivado su cuenta debido a 3 intentos fallidos de inicio de sesión.");
                    return null;
                }
            } else {
                int opt = MenuBotones("Usuario inactivo", "Menu", JOptionPane.ERROR_MESSAGE, new String[]{"Ingresar otro usuario", "Cancelar"});
                if (opt == 0) {
                    Login(clientes);
                } else {
                    return null;
                }
            }
        }

        return null;
    }

    public static void RealizarTransaccion(Cliente clientes[], Cliente usuario, Cuenta cuentas[]) {

        int transaccion = MenuBotones("Transaccion a realizar", "Tipo de transaccion", JOptionPane.DEFAULT_OPTION, new String[]{"Deposito", "Retiro", "Compra", "Transferencia", "Volver al menu"});
        if (transaccion == 4) {
            return;
        }

        int cuentaescogida = Cuentascliente(clientes, usuario);
        int cuentacliente = BuscarCuentaArreglo(cuentas, cuentaescogida);

        switch (transaccion) {
            case 0://Deposito

                double montodeposito = Double.parseDouble(JOptionPane.showInputDialog("Cuenta #" + cuentaescogida + "\nDigite el monto a depositar"));
                cuentas[cuentacliente].RealizarDepositoRetiro(cuentas[cuentacliente], TipoTransaccion.Deposito, montodeposito);
                break;

            case 1://Retiro
                while (true) {
                    double montoretiro = Double.parseDouble(JOptionPane.showInputDialog("Cuenta #" + cuentaescogida + "\nDigite el monto a retirar"));
                    boolean tienesaldo = VerificarSaldo(cuentas, montoretiro, cuentacliente);
                    if (tienesaldo == true && montoretiro >= 0) {
                        cuentas[cuentacliente].RealizarDepositoRetiro(cuentas[cuentacliente], TipoTransaccion.Retiro, montoretiro);
                        break;
                    } else {
                        int opt = MenuBotones("Asegurese de poner un monto mayor o igual a 0\nVerifique el saldo de su cuenta", "Error en el monto", JOptionPane.DEFAULT_OPTION, new String[]{"Ingresar otro monto", "Cancelar"});
                        if (opt == 0) {

                        } else {
                            break;
                        }
                    }
                }
                break;

            case 2://Compra
                while (true) {
                    double montocompra = Double.parseDouble(JOptionPane.showInputDialog("Cuenta #" + cuentaescogida + "\nDigite el monto de la compra"));
                    boolean tienesaldo = VerificarSaldo(cuentas, montocompra, cuentacliente);
                    if (tienesaldo == true && montocompra >= 0) {
                        String detalle = JOptionPane.showInputDialog("Digite el detalle de su compra");
                        cuentas[cuentacliente].RealizarCompraonline(cuentas[cuentacliente], detalle, montocompra);
                        break;
                    } else {
                        int opt = MenuBotones("Asegurese de poner un monto mayor o igual a 0\nVerifique el saldo de su cuenta", "Error en el monto", JOptionPane.DEFAULT_OPTION, new String[]{"Ingresar otro monto", "Cancelar"});
                        if (opt == 0) {

                        } else {
                            break;
                        }
                    }
                }
                break;

            case 3://Transferencia
                while (true) {
                    double montotransferencia = Double.parseDouble(JOptionPane.showInputDialog("Cuenta #" + cuentaescogida + "\nDigite el monto a transferir"));

                    boolean tienesaldo = VerificarSaldo(cuentas, montotransferencia, cuentacliente);

                    if (tienesaldo == true && montotransferencia > 0) {

                        int cuentadestinoingresada = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cuenta a realizar la transferencia"));

                        int cuentadestino = BuscarCuentaArreglo(cuentas, cuentadestinoingresada);

                        while (cuentadestino == -1) {
                            int opc = MenuBotones("Cuenta destino no encontrada", "Cuenta no encontrada", JOptionPane.ERROR_MESSAGE, new String[]{"Ingresar otra cuenta", "Cancelar transaccion"});

                            if (opc == 0) {
                                cuentadestinoingresada = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cuenta a realizar la transferencia"));
                                cuentadestino = BuscarCuentaArreglo(cuentas, cuentadestinoingresada);
                            } else {
                                return;
                            }
                        }
                        cuentas[cuentacliente].RealizarTranferencia(cuentas[cuentacliente], cuentas[cuentadestino], montotransferencia);
                        break;
                    } else {
                        int opt = MenuBotones("Asegurese de poner un monto mayor a 0\nVerifique el saldo de su cuenta", "Error en el monto", JOptionPane.DEFAULT_OPTION, new String[]{"Ingresar otro monto", "Cancelar"});
                        if (opt == 0) {

                        } else {
                            break;
                        }
                    }
                }

                break;

            default:
                throw new AssertionError();
        }
    }

    public static void MisCuentas(Cliente usuario, Cuenta cuentas[]) {

        Cuenta[] cuentascliente = new Cuenta[usuario.GetindexCuenta()];
        cuentascliente = usuario.getCuentas();

        for (int i = 0; i < cuentascliente.length; i++) {
            if (cuentascliente[i] != null) {

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Cuenta #" + cuentascliente[i].getNumerodecuenta());
                System.out.println("Tipo: " + cuentascliente[i].getTipo());
                System.out.println("Saldo: " + cuentascliente[i].getSaldo());
                System.out.println("Fecha de apertura: " + cuentascliente[i].getFecha() + "\n");

                System.out.println(cuentascliente[i].mostrarTodasLasTransacciones());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

            }
        }
    }

    public static void ActualizarMC(Cliente usuario, Cliente clientes[]) {

        while (true) {

            int opt = MenuBotones("Actualizar", "Actualizar datos", JOptionPane.QUESTION_MESSAGE, new String[]{"Nombre", "Telefono", "Correo", "Clave", "Salir"});

            switch (opt) {
                case 0://Nombre

                    String nombre = JOptionPane.showInputDialog("Digite el nuevo nombre: ");
                    usuario.setNombre(nombre);
                    System.out.println("Nombre actualizado con exito");

                    break;

                case 1://Telefono
                    usuario.setTelefono("Ingrese su numero de telefono\nFormato: xxxx-xxxx");
                    System.out.println("Telefono actualizado con exito");

                    break;

                case 2://Correo

                    while (true) {

                        String correo = JOptionPane.showInputDialog("Digite su correo");

                        boolean formato = verificarCorreo(correo);

                        if (formato == false) {
                            String OpcionMenuC[] = {"Agregar otro correo", "Cancelar"};
                            int opc = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Correo incorrecto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OpcionMenuC, "Agregar otro correo");

                            if (opc == 0) {

                            } else {
                                break;

                            }
                        } else {
                            usuario.setCorreo(correo);
                            System.out.println("Correo atualizado con exito");
                            break;
                        }
                    }
                    break;

                case 3://clave

                    String contrasena = DefinirContrasena(clientes);
                    if (contrasena != null) {
                        usuario.setClave(contrasena);
                        JOptionPane.showMessageDialog(null, "Contraseña actualizada con exito");
                    }

                    break;
                case 4://clave

                    break;

            }
            if (opt == 4) {
                break;
            }
        }

    }

    //******************************************************** Metodos **************************************************************************//
///
    public static int MenuBotones(String mensaje, String titulo, int imagen, String botones[]) {
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, imagen, null, botones, botones[0]);
    }

    public static boolean Acessoclavedinamica(Cliente clienteingresando) {

        int[][] clavedeacceso = clienteingresando.getTarjetaAcceso();
        int[] clavedeaccesoA = new int[20];
        int contador = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                clavedeaccesoA[contador] = clavedeacceso[i][j];
                contador++;
            }
        }

        String[] opciones = {"A1", "B1", "C1", "D1", "E1", "A2", "B2", "C2", "D2", "E2", "A3", "B3", "C3", "D3", "E3", "A4", "B4", "C4", "D4", "E4"};

        int primerparaleatorio = Numerosaleatorios(0, 20);
        int segundoparaleatorio = Numerosaleatorios(0, 20);
        int tercerparaleatorio = Numerosaleatorios(0, 20);

        System.out.println(clienteingresando.MostrarClavedinamica());
        boolean entradaValida = false;
        String entradaclaveCliente = null;
        while (!entradaValida) {
            entradaclaveCliente = JOptionPane.showInputDialog("Consulte su tarjeta de acceso y digite los accesos: " + opciones[primerparaleatorio] + " " + opciones[segundoparaleatorio] + " " + opciones[tercerparaleatorio] + " (Formato de ingreso XX-XX-XX)");
            if (entradaclaveCliente != null && entradaclaveCliente.length() == 8 && entradaclaveCliente.charAt(2) == '-' && entradaclaveCliente.charAt(5) == '-') {
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Formato de entrada inválido");
            }
        }
        int primeringresado = Integer.parseInt(entradaclaveCliente.substring(0, 2));
        int segundoingresado = Integer.parseInt(entradaclaveCliente.substring(3, 5));
        int terceringresado = Integer.parseInt(entradaclaveCliente.substring(6, 8));

        int valor1 = clavedeaccesoA[primerparaleatorio];
        int valor2 = clavedeaccesoA[segundoparaleatorio];
        int valor3 = clavedeaccesoA[tercerparaleatorio];

        if (primeringresado == valor1 && segundoingresado == valor2 && terceringresado == valor3) {
            JOptionPane.showMessageDialog(null, "Accediendo al sistema");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Acceso incorrecto");
            return Acessoclavedinamica(clienteingresando);
        }
    }

    public static int Getindex(Cliente clientes[]) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                return i;
            }
        }
        return -1; // Retorna -1 si no encuentra ningún elemento null
    }

    public static int GetindexCuentaArreglo(Cuenta cuentas[]) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                return i;
            }
        }
        return -1; // Retorna -1 si no encuentra ningún elemento null
    }

    public static String verificarID(Cliente clientes[]) {
        while (true) {
            String id = JOptionPane.showInputDialog("Ingrese su ID por favor (Formato: x-xxxx-xxxx)");

            if (id.length() != 11 || !id.substring(1, 2).equals("-") || !id.substring(6, 7).equals("-")) {
                JOptionPane.showMessageDialog(null, "El ID ingresado no tiene el formato correcto (x-xxxx-xxxx). Inténtelo de nuevo.");
                continue;
            }

            for (int i = 0; i < Getindex(clientes); i++) {
                if (id.equals(clientes[i].getIDcliente())) {
                    JOptionPane.showMessageDialog(null, "Cliente ya registrado");
                    return null;
                }
            }

            return id;
        }
    }

    public static boolean verificarCorreo(String correo) {
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

    public static int BuscarID(Cliente clientes[]) {

        String id = JOptionPane.showInputDialog("Digite el ID");

        for (int i = 0; i < Getindex(clientes); i++) {
            if (id.equals(clientes[i].getIDcliente())) {
                return i;
            }
        }
        return -1;

    }

    public static TipoCuenta Tipocuenta() {
        String Tipo[] = {"Cuenta corriente", "Ahorros", "Inversión", "Planilla"};
        int otc = JOptionPane.showOptionDialog(null, "Seleccione tipo de cuenta", "Tipo de cuenta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Tipo, Tipo[0]);

        switch (otc) {
            case 0:
                return TipoCuenta.Corriente;
            case 1:
                return TipoCuenta.Ahorros;
            case 2:
                return TipoCuenta.Inversión;
            case 3:
                return TipoCuenta.Planilla;
            default:
                throw new AssertionError();
        }
    }

    public static TipoCuenta TipocuentaGenerarReportes() {
        String Tipo[] = {"Cuenta corriente", "Ahorros", "Inversión", "Planilla", "Todas"};
        int otc = JOptionPane.showOptionDialog(null, "Seleccione tipo de cuenta", "Tipo de cuenta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Tipo, Tipo[0]);

        switch (otc) {
            case 0:
                return TipoCuenta.Corriente;
            case 1:
                return TipoCuenta.Ahorros;
            case 2:
                return TipoCuenta.Inversión;
            case 3:
                return TipoCuenta.Planilla;
            case 4:
                return TipoCuenta.Todas;
            default:
                throw new AssertionError();
        }
    }

    public static double Saldocuenta() {
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite el saldo de su cuenta"));

        if (saldo >= 0) {
            return saldo;
        } else {
            int opt = MenuBotones("Saldo no puede ser negativo", "Saldo negativo", JOptionPane.WARNING_MESSAGE, new String[]{"Ingresar otro saldo", "Cancelar"});
            if (opt == 0) {
                Saldocuenta();
            } else {
                return -1;
            }
            return -1;
        }
    }

    public static void Mostrar1cliente(Cliente clientes[], int num) {

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("          Cliente #" + (num + 1) + "          ");
        System.out.println("\n Nombre: " + clientes[num].getNombre()
                + "\n Identificacion: " + clientes[num].getIDcliente()
                + "\n Telefono: " + clientes[num].getTelefono()
                + "\n Correo Elcetronico: " + clientes[num].getCorreo()
                + "\n Usuario: " + clientes[num].getUsuario()
                + "\n Contraseña: " + clientes[num].getClave()
                + "\n Estado: " + clientes[num].getEstado()
                + "\n Clave dinamica: " + clientes[num].MostrarClavedinamica());
        System.out.println("");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

    }

    public static void Actualizar(Cliente clientes[], int num) {

        int opt = MenuBotones("Actualizar", "Actualizar datos", JOptionPane.QUESTION_MESSAGE, new String[]{"Nombre", "Telefono", "Correo", "Salir"});

        switch (opt) {
            case 0://Nombre

                String nombre = JOptionPane.showInputDialog("Digite el nuevo nombre: ");
                clientes[num].setNombre(nombre);
                System.out.println("Nombre actualizado con exito");
                Actualizar(clientes, num);
                break;

            case 1://Telefono
                clientes[num].setTelefono("Ingrese su numero de telefono\nFormato: xxxx-xxxx");
                System.out.println("Telefono actualizado con exito");
                Actualizar(clientes, num);
                break;

            case 2://Correo

                while (true) {

                    String correo = JOptionPane.showInputDialog("Digite su correo");

                    boolean formato = verificarCorreo(correo);

                    if (formato == false) {
                        String OpcionMenuC[] = {"Agregar otro correo", "Cancelar"};
                        int opc = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Correo incorrecto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OpcionMenuC, "Agregar otro correo");

                        if (opc == 0) {

                        } else {
                            break;

                        }
                    } else {
                        clientes[num].setCorreo(correo);
                        System.out.println("Correo atualizado con exito");
                        Actualizar(clientes, num);
                        break;
                    }

                }
                break;

            case 3://salir
                return;

            default:
                throw new AssertionError();
        }

    }

    public static void ActivarDesactivar(Cliente clientes[], int num) {

        String estado = clientes[num].getEstado();

        if (estado.equals("Activo")) {
            int optDesactivar = MenuBotones("Desactivar cuenta de " + clientes[num].getNombre(), "Desactivacion de cuenta", JOptionPane.QUESTION_MESSAGE, new String[]{"Desactivar", "Salir"});

            if (optDesactivar == 0) {
                clientes[num].setEstado("Inactivo");
                System.out.println("El cliente " + clientes[num].getNombre() + " se ha desactivado de forma correcta");
            }

        }
        if (estado.equals("Inactivo")) {
            int optActivar = MenuBotones("Activar cuenta de " + clientes[num].getNombre(), "Activacion de cuenta", JOptionPane.QUESTION_MESSAGE, new String[]{"Activar", "Salir"});

            if (optActivar == 0) {
                clientes[num].setEstado("Activo");
                System.out.println("El cliente " + clientes[num].getNombre() + " se ha activado de forma correcta");

            }

        }

    }

    public static int mostrarBotonesCuentas(Cliente clientes[], int num) {
        int cantidadCuentas = clientes[num].GetindexCuenta();
        String[] cuentasLetras = new String[cantidadCuentas];
        int[] cuentas = new int[cantidadCuentas];
        for (int i = 0; i < cantidadCuentas; i++) {
            cuentasLetras[i] = Integer.toString(clientes[num].getCuentas()[i].getNumerodecuenta());
            cuentas[i] = clientes[num].getCuentas()[i].getNumerodecuenta();
        }

        int opt = MenuBotones("Seleccione una cuenta", "Cuentas", JOptionPane.DEFAULT_OPTION, cuentasLetras);

        return cuentas[opt];
    }

    public static int Numerosaleatorios(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static String DefinirContrasena(Cliente clientes[]) {

        String contrasenaingresada = JOptionPane.showInputDialog(null,
                "Ingrese una clave que cumpla con las siguientes condiciones:\n"
                        + "- Debe tener mínimo 6 caracteres y un máximo de 10.\n"
                        + "- Debe contener al menos un número.\n"
                        + "- Debe contener al menos una letra.");

        if (contrasenaingresada.length() >= 6 && contrasenaingresada.length() <= 10) {
            if (contrasenaingresada.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).*$")) {

                while (true) {

                    String contrasenaconfirmar = JOptionPane.showInputDialog(null, "Ingrese nuevamente la clave");

                    if (contrasenaconfirmar.equals(contrasenaingresada)) {
                        return contrasenaconfirmar;
                    } else {
                        int opt = MenuBotones("Contraseñas no coinciden", "Contraseña invalida", JOptionPane.ERROR_MESSAGE, new String[]{"Confirmar de nuevo la clave", "Cancelar"});

                        if (opt == 0) {

                        } else {
                            return null;
                        }

                    }
                    break;
                }
            } else {
                int opt = MenuBotones("La clave no cumple con las condiciones mínimas de seguridad: Debe tener mínimo 1 numero y 1 letra", "Contraseña no valida", JOptionPane.ERROR_MESSAGE, new String[]{"Agregar otra contraseña", "Cancelar"});
                if (opt == 0) {
                    DefinirContrasena(clientes);
                } else {
                    return null;
                }
            }

        } else {
            int opt = MenuBotones("La clave no cumple con las condiciones mínimas de seguridad: Debe tener mínimo 6 caracteres y un máximo de 10.", "Contraseña no valida", JOptionPane.ERROR_MESSAGE, new String[]{"Agregar otra contraseña", "Cancelar"});
            if (opt == 0) {
                DefinirContrasena(clientes);
            } else {
                return null;
            }

        }
        return null;
    }

    public static int BuscarUsuario(Cliente clientes[], String usuario) {

        for (int i = 0; i < Getindex(clientes); i++) {
            if (usuario.equals(clientes[i].getUsuario())) {
                return i;
            }

        }
        return -1;
    }

    public static int BuscarCuentaArreglo(Cuenta cuentas[], int cuenta) {

        for (int i = 0; i < GetindexCuentaArreglo(cuentas); i++) {
            if (cuenta == cuentas[i].getNumerodecuenta()) {
                return i;
            }
        }
        return -1;
    }

    public static boolean VerificarSaldo(Cuenta cuentas[], Double monto, int cuenta) {

        Double saldo = cuentas[cuenta].getSaldo();

        if (saldo >= monto) {
            return true;
        } else {
            return false;
        }
    }

    public static int Cuentascliente(Cliente clientes[], Cliente usuario) {

        int cantidadCuentas = usuario.GetindexCuenta();
        String[] cuentasLetras = new String[cantidadCuentas];
        int[] cuentas = new int[cantidadCuentas];
        for (int i = 0; i < cantidadCuentas; i++) {
            cuentasLetras[i] = Integer.toString(usuario.getCuentas()[i].getNumerodecuenta());
            cuentas[i] = usuario.getCuentas()[i].getNumerodecuenta();
        }

        int opt = MenuBotones("Seleccione la cuenta", "Transacciones", JOptionPane.DEFAULT_OPTION, cuentasLetras);

        return cuentas[opt];
    }

    public static boolean Hayclientesgenerados(Cliente clientes[]) {
        if (clientes[0] == null) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return false;
        }
        return true;
    }

}