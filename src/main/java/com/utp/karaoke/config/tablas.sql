CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    pass VARCHAR(255),
    rol ENUM('administrador', 'recepcionista', 'cliente') NOT NULL
);

CREATE TABLE tarifa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    fecha DATE
);

CREATE TABLE sala (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50), -- nuevo campo: VIP, estándar, etc.
    mesas INT,
    id_tarifa INT,
    estado ENUM('libre', 'ocupada') DEFAULT 'libre',
    FOREIGN KEY (id_tarifa) REFERENCES tarifa(id)
);

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    dni VARCHAR(20),
    telefono VARCHAR(20),
    correo VARCHAR(100)
);

CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_sala INT,
    id_usuario INT,
    fecha DATE,
    total DECIMAL(10, 2),
    estado ENUM('pendiente', 'cancelada', 'finalizada'),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_sala) REFERENCES sala(id),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50), -- bebida, tiempo extra, etc.
    precio_unitario DECIMAL(10, 2)
);

CREATE TABLE consumo_reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT,
    id_producto INT,
    cantidad INT,
    comentario TEXT,
    FOREIGN KEY (id_reserva) REFERENCES reserva(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE configuracion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ruc VARCHAR(20),
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    mensaje TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE auditoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tabla_afectada VARCHAR(50),
    accion VARCHAR(50), -- INSERT, UPDATE, DELETE
    usuario VARCHAR(100),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descripcion TEXT
);
