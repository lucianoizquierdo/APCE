--para insertar solicitudes de produccion

INSERT INTO solicitud_produccion(
             fecha_alta, id_usuario, nombre, descripcion, observaciones, 
            formato1, formato2, fondo, film, impreso, caja, color1, color2, 
            color3, id_tinta1, id_tinta2, id_tinta3, id_adhesivo, id_pigmento, 
            id_diluyente, id_aditivo, cantidad_rollos)
    VALUES (
             '2013-01-01', null, '', '', 'observaciones', 
            'F12MM', 'F100MTS', 'TRANSPARENTE', '_04MM', 1, 'C_36', 'NEGRO', '', 
            '', 15, null, null, 39, 40, 
            41, 42, 1000);
