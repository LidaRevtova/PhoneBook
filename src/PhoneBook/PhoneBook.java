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
        if(record.getName() == null || record.getPhoneNumber() == null || record.getName().isEmpty() || record.getPhoneNumber().isEmpty()){
            throw new RecordNotValid("Телефон или имя пустые");
        }
        int i = findId(record.getId());
        if (i == -1){
            throw new RecordNotFound("not found");
        } else {
            phoneBook.set(i, record);
        }

    }

    private int findId(long id) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
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
