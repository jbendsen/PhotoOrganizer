package dk.lundogbendsen.photoorganizer.client.data;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;

public class Oracle {
	public static RecordList getRecords(){
		RecordList list = new RecordList();
		list.add(new PhotoRecord("Billed A","20","A.png"));
		list.add(new PhotoRecord("Billed B","20","B.png"));
		list.add(new PhotoRecord("Billed C","20","C.png"));
		list.add(new PhotoRecord("Billed D","20","D.png"));
		
	
		return list;
	}
}
