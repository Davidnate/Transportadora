package GUI;
import conexion.conectar;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import registros.conductor;

/**
 *
 * @author Usuario
 */
public class GUIinterfaz extends javax.swing.JFrame {

    /**
     * Creates new form GUIinterfaz
     */
    public GUIinterfaz() {
        initComponents();
        cargarConductores();
        cargarContratos();
        cargarBuses();
        cargarRutas();
    }

    private void cargarConductores() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre Completo");

    String query = "SELECT id_conductor, nombre, apellido FROM conductores";
    try (Connection conn = conectar.conectar();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id_conductor");
            String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
            modelo.addRow(new Object[]{id, nombreCompleto});
        }

        TablaConductores.setModel(modelo); 
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar conductores.");
    }
}
    
    private void cargarContratos() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Id contrato");
    modelo.addColumn("Id Conductor");
    modelo.addColumn("Nombre Completo");
    modelo.addColumn("Fecha Inicio");
    modelo.addColumn("Fecha Terminación");

    String query = "SELECT c.id_contrato, c.id_conductor, c.fecha_inicio, c.fecha_terminacion, c.valor_total, "
                 + "d.nombre, d.apellido "
                 + "FROM contratos c "
                 + "JOIN conductores d ON c.id_conductor = d.id_conductor"; 
    try (Connection conn = conectar.conectar();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int idContrato = rs.getInt("id_contrato");
            int idConductor = rs.getInt("id_conductor");
            String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
            Date fechainicio = rs.getDate("fecha_inicio");
            Date fechaterminacion = rs.getDate("fecha_terminacion");

            modelo.addRow(new Object[]{idContrato, idConductor, nombreCompleto, fechainicio, fechaterminacion});
        }


        TablaContratos.setModel(modelo);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar contratos.");
    }
}
    
    private void cargarBuses() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Id bus");
    modelo.addColumn("Id Conductor");
    modelo.addColumn("Nombre Completo");
    modelo.addColumn("Placa");
    modelo.addColumn("Modelo");
    modelo.addColumn("Capacidad");
    modelo.addColumn("Fecha Registro");

    String query = "SELECT b.id_bus, b.id_conductor, b.placa, b.modelo, b.capacidad, b.fecha_registro,"
                 + "c.nombre, c.apellido "
                 + "FROM buses b "
                 + "JOIN conductores c ON b.id_conductor = c.id_conductor";
    try (Connection conn = conectar.conectar();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int idbus = rs.getInt("id_bus");
            int idConductor = rs.getInt("id_conductor");
            String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
            Date fechaRegistro = rs.getDate("fecha_registro");
            String placa = rs.getString("placa");
            String modeloBus = rs.getString("modelo");
            int capacidad = rs.getInt("capacidad");

            modelo.addRow(new Object[]{idbus, idConductor, nombreCompleto, placa, modeloBus, capacidad, fechaRegistro});
        }


        Tabla_buses.setModel(modelo);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar contratos.");
    }
}
    
    private void cargarRutas() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Id Ruta");
    modelo.addColumn("Id Conductor");
    modelo.addColumn("Nombre Completo");
    modelo.addColumn("Origen");
    modelo.addColumn("Destino");
    modelo.addColumn("Distancia (km)");
    modelo.addColumn("Duración Estimada (min)");
    modelo.addColumn("Fecha Asignación");

    String query = "SELECT r.id_ruta, r.id_conductor, r.origen, r.destino, r.distancia_km, r.duracion_estimada, r.fecha_asignacion, "
                 + "c.nombre, c.apellido "
                 + "FROM rutas r "
                 + "JOIN conductores c ON r.id_conductor = c.id_conductor";
    try (Connection conn = conectar.conectar();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int idRuta = rs.getInt("id_ruta");
            int idConductor = rs.getInt("id_conductor");
            String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
            String origen = rs.getString("origen");
            String destino = rs.getString("destino");
            String distancia = rs.getString("distancia_km");
            int duracion = rs.getInt("duracion_estimada");
            Date fechaAsignacion = rs.getDate("fecha_asignacion");

            modelo.addRow(new Object[]{idRuta, idConductor, nombreCompleto, origen, destino, distancia, duracion, fechaAsignacion});
        }

        Tabla_rutas.setModel(modelo);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar las rutas.");
    }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaRegistro = new com.toedter.calendar.JDateChooser();
        ConsultarConductor = new javax.swing.JButton();
        RegistrarConductor = new javax.swing.JButton();
        ModificarConductor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConductores = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ContratoInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        ContratoFin = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        ContratoValor = new javax.swing.JTextField();
        Select_Conductor = new javax.swing.JComboBox();
        RegistrarContrato = new javax.swing.JButton();
        RevonarContrato = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaContratos = new javax.swing.JTable();
        ConsultarContrato = new javax.swing.JButton();
        Borrar_Contrato = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Placa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Modelo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Capacidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Fregistro_bus = new com.toedter.calendar.JDateChooser();
        Select_Con = new javax.swing.JComboBox();
        Registrar_bus = new javax.swing.JButton();
        Modificar_bus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_buses = new javax.swing.JTable();
        Consultar_bus = new javax.swing.JButton();
        Borrar_bus = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Origen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Destino = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Distancia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Duracion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Fecha_asignacion = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla_rutas = new javax.swing.JTable();
        Registrar_ruta = new javax.swing.JButton();
        Consultar_ruta = new javax.swing.JButton();
        Modificar_ruta = new javax.swing.JButton();
        Conductores = new javax.swing.JComboBox();
        Borrar_ruta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        txtNombre.setName("txtNombre"); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Apellido");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de nacimiento");

        jLabel4.setText("Telefono");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel5.setText("Direccion");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel6.setText("Correo");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de registro");

        ConsultarConductor.setText("Consultar");
        ConsultarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarConductorActionPerformed(evt);
            }
        });

        RegistrarConductor.setText("Registrar");
        RegistrarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarConductorActionPerformed(evt);
            }
        });

        ModificarConductor.setText("Modificar");
        ModificarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarConductorActionPerformed(evt);
            }
        });

        TablaConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaConductores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(RegistrarConductor)
                            .addGap(18, 18, 18)
                            .addComponent(ConsultarConductor)
                            .addGap(26, 26, 26)
                            .addComponent(ModificarConductor))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsultarConductor)
                    .addComponent(RegistrarConductor)
                    .addComponent(ModificarConductor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Conductor", jPanel2);

        jLabel8.setText("Fecha inicio");

        jLabel9.setText("Fecha Terminacion");

        jLabel10.setText("Valor ");

        Select_Conductor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un conductor" }));
        Select_Conductor.setActionCommand("\n");
        Select_Conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_ConductorActionPerformed(evt);
            }
        });

        RegistrarContrato.setText("Registrar");
        RegistrarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarContratoActionPerformed(evt);
            }
        });

        RevonarContrato.setText("Renovar");
        RevonarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevonarContratoActionPerformed(evt);
            }
        });

        TablaContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablaContratos);

        ConsultarContrato.setText("Consultar");
        ConsultarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarContratoActionPerformed(evt);
            }
        });

        Borrar_Contrato.setText("Borrar");
        Borrar_Contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar_ContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ContratoFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ContratoValor)))
                            .addComponent(Select_Conductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(RegistrarContrato)
                                .addGap(29, 29, 29)
                                .addComponent(ConsultarContrato)
                                .addGap(18, 18, 18)
                                .addComponent(RevonarContrato)))
                        .addGap(18, 18, 18)
                        .addComponent(Borrar_Contrato)
                        .addGap(445, 445, 445))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(67, 67, 67)
                        .addComponent(ContratoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContratoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContratoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(ContratoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Select_Conductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarContrato)
                    .addComponent(RevonarContrato)
                    .addComponent(ConsultarContrato)
                    .addComponent(Borrar_Contrato))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contratos ", jPanel3);

        jLabel11.setText("Placa");

        jLabel12.setText("Modelo");

        jLabel13.setText("Capacidad");

        jLabel14.setText("Fecha registro");

        Select_Con.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un conductor" }));
        Select_Con.setToolTipText("");
        Select_Con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_ConActionPerformed(evt);
            }
        });

        Registrar_bus.setText("Registrar");
        Registrar_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_busActionPerformed(evt);
            }
        });

        Modificar_bus.setText("Modificar");
        Modificar_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_busActionPerformed(evt);
            }
        });

        Tabla_buses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Tabla_buses);

        Consultar_bus.setText("Consultar");
        Consultar_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultar_busActionPerformed(evt);
            }
        });

        Borrar_bus.setText("Borrar");
        Borrar_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar_busActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Select_Con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(65, 65, 65))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Capacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Placa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Modelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fregistro_bus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(511, 511, 511))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(Registrar_bus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Consultar_bus)
                .addGap(18, 18, 18)
                .addComponent(Modificar_bus)
                .addGap(18, 18, 18)
                .addComponent(Borrar_bus)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(Fregistro_bus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(Select_Con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar_bus)
                    .addComponent(Modificar_bus)
                    .addComponent(Consultar_bus)
                    .addComponent(Borrar_bus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buses", jPanel4);

        jLabel15.setText("Origen");

        jLabel16.setText("Destino");

        jLabel17.setText("Distancia en Km");

        jLabel18.setText("Duracion estimada");

        jLabel19.setText("Fecha de asignacion");

        Tabla_rutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(Tabla_rutas);

        Registrar_ruta.setText("Registrar");
        Registrar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_rutaActionPerformed(evt);
            }
        });

        Consultar_ruta.setText("Consultar");
        Consultar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consultar_rutaActionPerformed(evt);
            }
        });

        Modificar_ruta.setText("Modificar");
        Modificar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_rutaActionPerformed(evt);
            }
        });

        Conductores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "selecciona conductores" }));
        Conductores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Conductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConductoresActionPerformed(evt);
            }
        });

        Borrar_ruta.setText("Borrar");
        Borrar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar_rutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(Registrar_ruta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Consultar_ruta)
                        .addGap(18, 18, 18)
                        .addComponent(Modificar_ruta)
                        .addGap(18, 18, 18)
                        .addComponent(Borrar_ruta))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Conductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Fecha_asignacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(Duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(Fecha_asignacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Conductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar_ruta)
                    .addComponent(Modificar_ruta)
                    .addComponent(Consultar_ruta)
                    .addComponent(Borrar_ruta))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Rutas", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void ConsultarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarConductorActionPerformed
    int filaSeleccionada = TablaConductores.getSelectedRow(); 

    if (filaSeleccionada >= 0) {
        int idConductor = (int) TablaConductores.getValueAt(filaSeleccionada, 0);

        String query = "SELECT nombre, apellido, telefono, direccion, fecha_nacimiento, fecha_registro, correo FROM conductores WHERE id_conductor = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idConductor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtTelefono.setText(rs.getString("telefono"));
                txtDireccion.setText(rs.getString("direccion"));
                txtCorreo.setText(rs.getString("correo"));
                txtFechaNacimiento.setDate(rs.getDate("fecha_nacimiento"));
                txtFechaRegistro.setDate(rs.getDate("fecha_registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar el conductor.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un conductor de la tabla.");
    }
    }//GEN-LAST:event_ConsultarConductorActionPerformed

    private void RegistrarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarConductorActionPerformed
 
    String nombre = txtNombre.getText();
    String apellido = txtApellido.getText();
    java.util.Date  nacimiento = txtFechaNacimiento.getDate();
    String telefono = txtTelefono.getText();
    String direccion = txtDireccion.getText();
    String correo = txtCorreo.getText();
    java.util.Date fechaRegistro = txtFechaRegistro.getDate();
    
    if (txtFechaNacimiento == null || txtFechaRegistro == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona todas las fechas.");
        return;
    }


    java.sql.Date fechaNacimientoSql = new java.sql.Date(nacimiento.getTime());
    java.sql.Date fechaRegistroSql = new java.sql.Date(fechaRegistro.getTime());


    String query = "INSERT INTO conductores (nombre, apellido,fecha_nacimiento, telefono, direccion,correo,fecha_registro ) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = conectar.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setDate(3, fechaNacimientoSql);
        stmt.setString(4, telefono);
        stmt.setString(5, direccion);
        stmt.setString(6, correo);
        stmt.setDate(7, fechaRegistroSql);
        
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Conductor registrado exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al registrar el conductor.");
    }
    }//GEN-LAST:event_RegistrarConductorActionPerformed

    private void ModificarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarConductorActionPerformed
    int filaSeleccionada = TablaConductores.getSelectedRow(); 

    if (filaSeleccionada >= 0) {
        int idConductor = (int) TablaConductores.getValueAt(filaSeleccionada, 0);

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String correo = txtCorreo.getText();
        java.util.Date fechaNacimiento = txtFechaNacimiento.getDate();
        java.util.Date fechaRegistro = txtFechaRegistro.getDate();

        java.sql.Date fechaNacimientoSql = new java.sql.Date(fechaNacimiento.getTime());
        java.sql.Date fechaRegistroSql = new java.sql.Date(fechaRegistro.getTime());

        String query = "UPDATE conductores SET nombre = ?, apellido = ?,fecha_nacimiento = ?, telefono = ?, direccion = ?,correo = ?, fecha_registro = ?  WHERE id_conductor = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setDate(3, fechaNacimientoSql);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);
            stmt.setString(6, correo);
            stmt.setDate(7, fechaRegistroSql);
            stmt.setInt(8, idConductor);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Conductor modificado exitosamente.");
            cargarConductores(); 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar el conductor.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un conductor de la tabla.");
    }
    }//GEN-LAST:event_ModificarConductorActionPerformed
private boolean conductoresCargados = false;
    private void Select_ConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_ConductorActionPerformed
    if (!conductoresCargados) {
        String query = "SELECT id_conductor, nombre, apellido FROM conductores"; 
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            Select_Conductor.removeAllItems(); 

            while (rs.next()) {
                int id = rs.getInt("id_conductor");
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                

                Select_Conductor.addItem(new conductor(id, nombreCompleto));
                
            }
            conductoresCargados = true; 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar conductores.");
            conductoresCargados = false;
        }
    }

    }//GEN-LAST:event_Select_ConductorActionPerformed

    private void RegistrarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarContratoActionPerformed
    conductor selectedConductor = (conductor) Select_Conductor.getSelectedItem();
    if (selectedConductor == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un conductor.");
        return;
    }
        
    int idConductor = selectedConductor.getId();  
    java.util.Date  contratoini = ContratoInicio.getDate();
    java.util.Date  contratofin = ContratoFin.getDate();
    String valorTotal = ContratoValor.getText();
    
    if (txtFechaNacimiento == null || txtFechaRegistro == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona todas las fechas.");
        return;
    }

    java.sql.Date contratoiniSql = new java.sql.Date(contratoini.getTime());
    java.sql.Date contratofinSql = new java.sql.Date(contratofin.getTime());

    String query = "INSERT INTO contratos (id_conductor, fecha_inicio, fecha_terminacion, valor_total) VALUES (?, ?, ?, ?)";

    try (Connection conn = conectar.conectar();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, idConductor);
        stmt.setDate(2, contratoiniSql);
        stmt.setDate(3, contratofinSql);
        stmt.setBigDecimal(4, new BigDecimal(valorTotal));
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Contrato registrado exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al registrar el contrato.");
    }
    }//GEN-LAST:event_RegistrarContratoActionPerformed

    private void RevonarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevonarContratoActionPerformed
    int filaSeleccionada = TablaContratos.getSelectedRow(); 

    if (filaSeleccionada >= 0) {
        int idConductor = (int) TablaContratos.getValueAt(filaSeleccionada, 0);
        
        
        java.util.Date fechainicio = ContratoInicio.getDate();
        java.util.Date fechatermina = ContratoFin.getDate();
        String valorTotal = ContratoValor.getText();

        java.sql.Date fechainicioSql = new java.sql.Date(fechainicio.getTime());
        java.sql.Date fechaterminaSql = new java.sql.Date(fechatermina.getTime());

        String query = "UPDATE contratos SET fecha_inicio = ?, fecha_terminacion = ?, valor_total = ?  WHERE id_contrato = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setDate(1, fechainicioSql);
            stmt.setDate(2, fechaterminaSql);
            stmt.setBigDecimal(3, new BigDecimal(valorTotal));
            stmt.setInt(4, idConductor);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Contrato modificado exitosamente.");
            cargarConductores();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar el contrato.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un contrato de la tabla.");
    }
    }//GEN-LAST:event_RevonarContratoActionPerformed

    private void ConsultarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarContratoActionPerformed
        int filaSeleccionada = TablaContratos.getSelectedRow(); 

    if (filaSeleccionada >= 0) {
        int idConductor = (int) TablaContratos.getValueAt(filaSeleccionada, 0);

        String query = "SELECT valor_total FROM contratos WHERE id_contrato = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idConductor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ContratoValor.setText(rs.getString("valor_total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar el conductor.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un conductor de la tabla.");
    }
    }//GEN-LAST:event_ConsultarContratoActionPerformed

    private void Select_ConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select_ConActionPerformed
      if (!conductoresCargados) {
        String query = "SELECT id_conductor, nombre, apellido FROM conductores"; 
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            Select_Con.removeAllItems(); 

            while (rs.next()) {
                int id = rs.getInt("id_conductor");
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                

                Select_Con.addItem(new conductor(id, nombreCompleto));
            }
            conductoresCargados = true; 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar conductores.");
        }
    }
 
    }//GEN-LAST:event_Select_ConActionPerformed

    private void Registrar_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_busActionPerformed
conductor selectedConductor = (conductor) Select_Con.getSelectedItem();
    if (selectedConductor == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un conductor.");
        return;
    }
    
    int idConductor = selectedConductor.getId();  
    String placa = Placa.getText();
    String modelo = Modelo.getText();
    String capacidad = Capacidad.getText();
    java.util.Date fechaRegistro = Fregistro_bus.getDate();
    
    if (fechaRegistro == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona la fecha.");
        return;
    }
    java.sql.Date fechaRegistroSql = new java.sql.Date(fechaRegistro.getTime());


    String verificarQuery = "SELECT COUNT(*) FROM buses WHERE id_conductor = ?";
    
    try (Connection conn = conectar.conectar(); 
         PreparedStatement verificarStmt = conn.prepareStatement(verificarQuery)) {
        
        verificarStmt.setInt(1, idConductor);
        ResultSet rs = verificarStmt.executeQuery();
        
        if (rs.next() && rs.getInt(1) > 0) {

            JOptionPane.showMessageDialog(this, "Este conductor ya tiene un bus asignado.");
            return;
        }
        

        String query = "INSERT INTO buses (id_conductor, placa, modelo, capacidad, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idConductor);
            stmt.setString(2, placa);
            stmt.setString(3, modelo);
            stmt.setString(4, capacidad);
            stmt.setDate(5, fechaRegistroSql);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Bus registrado exitosamente.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al registrar el bus.");
    }

    }//GEN-LAST:event_Registrar_busActionPerformed

    private void Consultar_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultar_busActionPerformed
        int filaSeleccionada = Tabla_buses.getSelectedRow();

    if (filaSeleccionada >= 0) {
        int idConductor = (int) Tabla_buses.getValueAt(filaSeleccionada, 0);

        String query = "SELECT placa, modelo, capacidad FROM buses WHERE id_conductor = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idConductor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Placa.setText(rs.getString("placa"));
                Modelo.setText(rs.getString("modelo"));
                Capacidad.setText(rs.getString("capacidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar el bus.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un bus de la tabla.");
    }
    }//GEN-LAST:event_Consultar_busActionPerformed

    private void Modificar_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_busActionPerformed
    int filaSeleccionada = Tabla_buses.getSelectedRow();

    if (filaSeleccionada >= 0) {
        int idBus = (int) Tabla_buses.getValueAt(filaSeleccionada, 0); 
        String placa = Placa.getText();
        String modelo = Modelo.getText();
        String capacidad = Capacidad.getText();
        java.util.Date fechaRegistro = Fregistro_bus.getDate(); 


        if (fechaRegistro == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una fecha de registro.");
            return;
        }

        java.sql.Date fechaRegistroSql = new java.sql.Date(fechaRegistro.getTime());

        String query = "UPDATE buses SET placa = ?, modelo = ?, capacidad = ?, fecha_registro = ? WHERE id_bus = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, placa);
            stmt.setString(2, modelo);
            stmt.setInt(3, Integer.parseInt(capacidad)); 
            stmt.setDate(4, fechaRegistroSql);
            stmt.setInt(5, idBus); 

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Bus modificado exitosamente.");
            cargarBuses(); 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar el bus.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un bus de la tabla.");
    }
    }//GEN-LAST:event_Modificar_busActionPerformed

    private void Registrar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_rutaActionPerformed
    conductor selectedConductor = (conductor) Conductores.getSelectedItem();
    if (selectedConductor == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un conductor.");
        return;
    }
    
    int idConductor = selectedConductor.getId();  
    String origen = Origen.getText();
    String destino = Destino.getText();
    String distancia = Distancia.getText();
    String duracion = Duracion.getText();
    java.util.Date fechaAsignacion = Fecha_asignacion.getDate();
    
    if (Fecha_asignacion == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona la fecha.");
        return;
    }
    java.sql.Date fechaAsignacionSql = new java.sql.Date(fechaAsignacion.getTime());


    String queryContrato = "SELECT COUNT(*) FROM contratos WHERE id_conductor = ?";
    String queryBus = "SELECT COUNT(*) FROM buses WHERE id_conductor = ?";

    try (Connection conn = conectar.conectar();
         PreparedStatement stmtContrato = conn.prepareStatement(queryContrato);
         PreparedStatement stmtBus = conn.prepareStatement(queryBus)) {
        

        stmtContrato.setInt(1, idConductor);
        ResultSet rsContrato = stmtContrato.executeQuery();
        if (rsContrato.next() && rsContrato.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "El conductor no tiene un contrato asignado.");
            return;
        }


        stmtBus.setInt(1, idConductor);
        ResultSet rsBus = stmtBus.executeQuery();
        if (rsBus.next() && rsBus.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "El conductor no tiene un bus asignado.");
            return;
        }


        String query = "INSERT INTO rutas (id_conductor, origen, destino, distancia_km, duracion_estimada, fecha_asignacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmtRuta = conn.prepareStatement(query)) {
            stmtRuta.setInt(1, idConductor);
            stmtRuta.setString(2, origen);
            stmtRuta.setString(3, destino);
            stmtRuta.setString(4, distancia);
            stmtRuta.setString(5, duracion);
            stmtRuta.setDate(6, fechaAsignacionSql);
            
            stmtRuta.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ruta registrada exitosamente.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al registrar la ruta.");
    }
    }//GEN-LAST:event_Registrar_rutaActionPerformed

    private void Consultar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consultar_rutaActionPerformed
        int filaSeleccionada = Tabla_rutas.getSelectedRow(); 

    if (filaSeleccionada >= 0) {
        int idRuta = (int) Tabla_rutas.getValueAt(filaSeleccionada, 0);

        String query = "SELECT origen, destino, distancia_km, duracion_estimada, fecha_asignacion FROM rutas WHERE id_ruta = ?";
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idRuta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Origen.setText(rs.getString("origen"));
                Destino.setText(rs.getString("destino"));
                Distancia.setText(rs.getString("distancia_km"));
                Duracion.setText(String.valueOf(rs.getInt("duracion_estimada"))); 
                Fecha_asignacion.setDate(rs.getDate("fecha_asignacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al consultar la ruta.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una ruta de la tabla.");
    }
    }//GEN-LAST:event_Consultar_rutaActionPerformed

    private void Modificar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_rutaActionPerformed
    int filaSeleccionada = Tabla_rutas.getSelectedRow(); 

if (filaSeleccionada >= 0) {
    int idRuta = (int) Tabla_rutas.getValueAt(filaSeleccionada, 0);
    String origen = Origen.getText();
    String destino = Destino.getText();
    String distancia = Distancia.getText();
    String duracion = Duracion.getText();
    java.util.Date fechaAsignacion = Fecha_asignacion.getDate(); 

 
    if (fechaAsignacion == null) {
        JOptionPane.showMessageDialog(this, "Por favor selecciona una fecha de asignación.");
        return;
    }


    java.sql.Date fechaAsignacionSql = new java.sql.Date(fechaAsignacion.getTime());


    String query = "UPDATE rutas SET origen = ?, destino = ?, distancia_km = ?, duracion_estimada = ?, fecha_asignacion = ? WHERE id_ruta = ?";

    try (Connection conn = conectar.conectar();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, origen);
        stmt.setString(2, destino);
        stmt.setString(3, distancia); 
        stmt.setInt(4, Integer.parseInt(duracion));
        stmt.setDate(5, fechaAsignacionSql);
        stmt.setInt(6, idRuta); 

  
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Ruta modificada exitosamente.");
        cargarRutas(); 
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al modificar la ruta.");
    }
} else {
    JOptionPane.showMessageDialog(this, "Seleccione una ruta de la tabla.");
}
    }//GEN-LAST:event_Modificar_rutaActionPerformed

    private void ConductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConductoresActionPerformed
    if (!conductoresCargados) {
        String query = "SELECT id_conductor, nombre, apellido FROM conductores"; 
        try (Connection conn = conectar.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            Conductores.removeAllItems(); 

            while (rs.next()) {
                int id = rs.getInt("id_conductor");
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                

                Conductores.addItem(new conductor(id, nombreCompleto));
            }
            conductoresCargados = true; 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar conductores.");
        }
    }
 
    }//GEN-LAST:event_ConductoresActionPerformed

    private void Borrar_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_busActionPerformed
    int filaSeleccionada = Tabla_buses.getSelectedRow();
    
    if (filaSeleccionada >= 0) {

        int idBus = (int) Tabla_buses.getValueAt(filaSeleccionada, 0);


        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que deseas borrar este bus?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            String query = "DELETE FROM buses WHERE id_bus = ?";

            try (Connection conn = conectar.conectar(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                 
                stmt.setInt(1, idBus);
                stmt.executeUpdate();
                

                JOptionPane.showMessageDialog(this, "Bus borrado exitosamente.");
                

                cargarBuses(); 
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al borrar el bus.");
            }
        }
    } else {

        JOptionPane.showMessageDialog(this, "Seleccione un bus de la tabla.");
    }
    }//GEN-LAST:event_Borrar_busActionPerformed

    private void Borrar_ContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_ContratoActionPerformed
        
    int filaSeleccionada = TablaContratos.getSelectedRow();
    
    if (filaSeleccionada >= 0) {

        int idContrato = (int) TablaContratos.getValueAt(filaSeleccionada, 0);


        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que deseas borrar este contrato?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            String query = "DELETE FROM contratos WHERE id_contrato = ?";

            try (Connection conn = conectar.conectar(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                 
                stmt.setInt(1, idContrato);
                stmt.executeUpdate();
                

                JOptionPane.showMessageDialog(this, "Contrato borrado exitosamente.");
                

                cargarBuses(); 
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al borrar el Contrato.");
            }
        }
    } else {

        JOptionPane.showMessageDialog(this, "Seleccione un contrato de la tabla.");
    }
    }//GEN-LAST:event_Borrar_ContratoActionPerformed

    private void Borrar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_rutaActionPerformed
    int filaSeleccionada = Tabla_rutas.getSelectedRow();
    
    if (filaSeleccionada >= 0) {

        int idContrato = (int) Tabla_rutas.getValueAt(filaSeleccionada, 0);


        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que deseas borrar esta ruta?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            String query = "DELETE FROM rutas WHERE id_ruta = ?";

            try (Connection conn = conectar.conectar(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                 
                stmt.setInt(1, idContrato);
                stmt.executeUpdate();
                

                JOptionPane.showMessageDialog(this, "Ruta borrada exitosamente.");
                

                cargarBuses(); 
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al borrar la Ruta.");
            }
        }
    } else {

        JOptionPane.showMessageDialog(this, "Seleccione una ruta de la tabla.");
    }
    }//GEN-LAST:event_Borrar_rutaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIinterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIinterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIinterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIinterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIinterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar_Contrato;
    private javax.swing.JButton Borrar_bus;
    private javax.swing.JButton Borrar_ruta;
    public javax.swing.JTextField Capacidad;
    public javax.swing.JComboBox Conductores;
    private javax.swing.JButton ConsultarConductor;
    public javax.swing.JButton ConsultarContrato;
    private javax.swing.JButton Consultar_bus;
    private javax.swing.JButton Consultar_ruta;
    private com.toedter.calendar.JDateChooser ContratoFin;
    private com.toedter.calendar.JDateChooser ContratoInicio;
    private javax.swing.JTextField ContratoValor;
    public javax.swing.JTextField Destino;
    public javax.swing.JTextField Distancia;
    public javax.swing.JTextField Duracion;
    public com.toedter.calendar.JDateChooser Fecha_asignacion;
    public com.toedter.calendar.JDateChooser Fregistro_bus;
    public javax.swing.JTextField Modelo;
    private javax.swing.JButton ModificarConductor;
    public javax.swing.JButton Modificar_bus;
    public javax.swing.JButton Modificar_ruta;
    public javax.swing.JTextField Origen;
    public javax.swing.JTextField Placa;
    private javax.swing.JButton RegistrarConductor;
    public javax.swing.JButton RegistrarContrato;
    public javax.swing.JButton Registrar_bus;
    public javax.swing.JButton Registrar_ruta;
    private javax.swing.JButton RevonarContrato;
    private javax.swing.JComboBox Select_Con;
    public javax.swing.JComboBox Select_Conductor;
    public javax.swing.JTable TablaConductores;
    private javax.swing.JTable TablaContratos;
    public javax.swing.JTable Tabla_buses;
    public javax.swing.JTable Tabla_rutas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private com.toedter.calendar.JDateChooser txtFechaRegistro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
