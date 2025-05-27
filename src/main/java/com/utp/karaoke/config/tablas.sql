-- Tabla: configuracion
CREATE TABLE configuracion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ruc VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(150),
    mensaje TEXT
);

-- Tabla: sala
CREATE TABLE sala (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    mesas INT NOT NULL
);

-- Tabla: usuario
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

-- Tabla: reserva
CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_sala INT NOT NULL,
    num_mesa INT NOT NULL,
    fecha DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    id_usuario INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_sala) REFERENCES sala(id),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

-- Tabla: detalle_reserva
CREATE TABLE detalle_reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    cantidad INT NOT NULL,
    comentario TEXT,
    id_reserva INT NOT NULL,
    FOREIGN KEY (id_reserva) REFERENCES reserva(id)
);

-- Tabla: tarifa
CREATE TABLE tarifa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    fecha DATE NOT NULL
);