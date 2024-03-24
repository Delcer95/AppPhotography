package com.example.appphotography.Config;

public class Transacciones {

    public static final String tablaPhoto = "Photo";
    public static final String idPhoto = "idPhoto";
    public static final String blobPhoto = "blobPhoto";
    public static final String descripcion = "descripcion";

    public static final String CreateTablePhotos =
            "CREATE TABLE Photo(idPhoto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "blobPhoto BLOB, descripcion TEXT)";
    public static final String DropeTablePhotos =
            "DROPE TABLE IF EXISTS Photo";

    /* Base de Datos */
    public static final String NameDataBase = "DBPhoto";
}
