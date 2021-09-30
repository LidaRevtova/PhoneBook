package com.company;

import Exceptions.PhoneNumberExists;
import Exceptions.RecordNotFound;
import Exceptions.RecordNotValid;
import PhoneBook.PhoneBook;
import PhoneBook.Record;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(new Record(1, "8 999 111 22 33", "Inna"));
        records.add(new Record(1, "8 999 111 22 33", "Inna"));
        records.add(new Record(3, "8 999 111 44 33", "Masha"));
//        records.add(new Record(4, "8 999 111 55 33", "Pasha"));
//        records.add(new Record(5, "8 999 111 44 63", "Dasha"));


        for (Record record : records){
            try {
                book.createRecord(record);
            }
            catch (PhoneNumberExists e){
                System.out.println(e);
            }
        }
        //book.printInfo();

        System.out.println("");

        Record recordUpdate = new Record(1, "", "");
        try {
            book.updateRecord(recordUpdate);
        }
        catch (RecordNotFound e){
            System.out.println(e);
        }
        catch (RecordNotValid e){
            System.out.println(e);
        }
        //book.printInfo();
        System.out.println("");


        long idDel = 7;
        try {
            book.deleteRecord(idDel);
        }
        catch (RecordNotFound e){
            System.out.println(e);
        }
        //book.printInfo();

    }
}
