public class RecordBox <T>{
    private T[]records;
    public RecordBox(T[]records){
        this.records=records;
    }
    public void printAll(){
        for (int i=0;i< records.length;i++){
            System.out.println(records[i]);
        }
    }
    public T getRecord(int index){
        for (int i=0;i< records.length;i++){
            if (records[i]==records[index]){
                return records[i];
            }
        }return null;

    }
    public int getSize(){
        return records.length;
    }
}
