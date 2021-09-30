package PhoneBook;

import Exceptions.PhoneNumberExists;
import Exceptions.RecordNotFound;
import Exceptions.RecordNotValid;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Record> phoneBook = new ArrayList<Record>();

    public void createRecord(Record record) throws PhoneNumberExists {
        if (phoneBook.contains(record)) {
            throw new PhoneNumberExists("Запись с таким телефоном уже существует");
        } else {
            phoneBook.add(record);
        }
    }

    public List<Record> getAllRecords() {
        return phoneBook;
    }

    private boolean hasRecord(long id) {
        for (Record oldRecord : phoneBook) {
            if (oldRecord.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid {
        if (!hasRecord(record.getId())) {
            throw new RecordNotFound("Запись с таким id не найдена.");
        }

        if(record.getName().isEmpty() || record.getPhoneNumber().isEmpty() || record.getName() == null || record.getPhoneNumber() == null){
            throw new RecordNotValid("Телефон или имя пустые");
        }

        deleteRecord(record.getId());
//        try {
//            createRecord(record);
//        } catch (PhoneNumberExists e){
//            System.out.println("Хоть я и уверен, что это исключение не отработает, но я вынужден его обработать!");
//        }
    }

    public void deleteRecord(long id) throws RecordNotFound {
        for (Record record:phoneBook) {
            if (record.getId() == id){
                phoneBook.remove(record);
                return;
            }
        }
        throw new RecordNotFound("Запись с таким id не найдена");
    }

    public void printInfo() {
        for (Record record : phoneBook) {
            record.printInfo();
        }

    }
}
