package dk.lundogbendsen.photoorganizer.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class AlbumXmlDS extends DataSource {

    private static AlbumXmlDS instance = null;

    public static AlbumXmlDS getInstance() {
        if (instance == null) {
            instance = new AlbumXmlDS("albumDS");
        }
        return instance;
    }

    public AlbumXmlDS(String id) {

        setID(id);
        setRecordXPath("/List/album");


        DataSourceTextField itemNameField = new DataSourceTextField("albumName", "Item", 128, true);
        DataSourceTextField keyField = new DataSourceTextField("albumId", "id", 128, true);
        keyField.setPrimaryKey(true);

        DataSourceTextField parentField = new DataSourceTextField("parentID", null);
        parentField.setHidden(true);
        parentField.setRequired(true);
        parentField.setRootValue("root");
        parentField.setForeignKey("albumDS.albumId");


        setFields(itemNameField, parentField,keyField);

        setDataURL("ds/test_data/album.data.xml");
        
        setClientOnly(true);

    }
}