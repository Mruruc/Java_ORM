package com.mruruc;

import com.mruruc.model.User;
import com.mruruc.repository.CRUD;
import com.mruruc.repository.CRUDImpl;
import com.mruruc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        CRUD<User,UUID> crud = new CRUDImpl<>(User.class);
//        System.out.println(
//                crud.findById(UUID.fromString("abb0095d-fe31-41a2-b5ae-0c5c1f43508"))
//        );

//       try{
//           crud.delete(UUID.fromString("abb0095d-fe31-41a2-b5ae-0c5c1f43509"));
//       }catch (Exception ex){
//           System.out.println(ex.getMessage());
//       }

//        System.out.println(
//                crud.findAll()
//        );

//        User user = new User();
//        user.setUsername("john@doe");
//        user.setPassword("johny_password");
////        User save = crud.save(user);
////        System.out.println("Saved User: \n" + save);
//
////        user.setUsername("jane@doe21");
////        User update = crud.update(save.getId(), user);
////        System.out.println("==============================");
////        System.out.println(
////                "Updated User: \n " + update
////        );
//
//        System.out.println(user.getId());

        crud.delete(UUID.fromString("cb5a45b0-d25b-4be9-9bee-679229a7831f"));

        HibernateUtil.shutdown();

    }
}
