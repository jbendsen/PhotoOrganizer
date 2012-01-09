package dk.lundogbendsen.photoorganizer.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class PhotoXmlDS extends DataSource {

    private static PhotoXmlDS instance = null;
    
  public static enum FieldNameEnum{
    	photoId,
    	photoName,
    	description,
    	albumId,
    	photoUrl,
    	tag;
    }

    public static PhotoXmlDS getInstance() {
        if (instance == null) {
            instance = new PhotoXmlDS();
        }
        return instance;
    }

    private PhotoXmlDS() {
        setID("PhotoXmlDS");
        setRecordXPath("/List/photo");
        setDataURL("ds/test_data/photo.data.xml");
        setClientOnly(true);
        
        DataSourceIntegerField pkField = new DataSourceIntegerField(FieldNameEnum.photoId.toString());
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceTextField photoNameField = new DataSourceTextField(FieldNameEnum.photoName.toString());
   
        DataSourceTextField descriptionField = new DataSourceTextField(FieldNameEnum.description.toString());
        
        DataSourceTextField albumIdField = new DataSourceTextField(FieldNameEnum.albumId.toString());
        albumIdField.setForeignKey(AlbumXmlDS.getInstance().getID()+"."+FieldNameEnum.albumId.toString());
        
        DataSourceTextField photoUrlField = new DataSourceTextField(FieldNameEnum.photoUrl.toString());
        
        DataSourceTextField tagField = new DataSourceTextField(FieldNameEnum.tag.toString());
 
        setFields(pkField, tagField,photoNameField, descriptionField, albumIdField, photoUrlField);
    }
}