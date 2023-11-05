package br.com.pyetro.reflections;
import br.com.pyetro.register.domain.dao.ClientMapDAO;
import br.com.pyetro.register.domain.dao.IClienteDAO;
import br.com.pyetro.register.domain.dao.IProductDAO;
import br.com.pyetro.register.domain.Client;
import br.com.pyetro.exception.TypeKeyNotFoundException;

import javax.swing.*;
public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args){
        iClienteDAO = new ClientMapDAO();

        String option = JOptionPane.showInputDialog(null, "Type 1 to register, 2 to search, 3 to delete, 4 to update, 5 to leave", "CRUD/Reflection@annotation",JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(option)){
            if("".equals(option)){
                leave();

            }

            option = JOptionPane.showInputDialog(null,"Invalid option, type 1 to register, 2 to search, 3 to delete, 4 to update, 5 to leave.","CRUD/Reflection@annotation",JOptionPane.INFORMATION_MESSAGE );
        }

        while (!isValidOption(option)){
            if(isLeaveOption(option)){
                leave();

            } else if(isRegister(option)){
                String data = JOptionPane.showInputDialog(null,"type the data separeted by comma", "register",JOptionPane.INFORMATION_MESSAGE);
                register(data);
            } else if(isSearch(option)){
                String data = JOptionPane.showInputDialog(null,"type the CPF.", "Search",JOptionPane.INFORMATION_MESSAGE);
                search(data);
            }

            option = JOptionPane.showInputDialog(null,"Type 1 to register, 2 to search, 3 to delete, 4 to update, 5 to leave","CRUD/Reflection@annotation",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void search(String data) {
        Client client = iClienteDAO.search(Long.parseLong(data));
        if(client != null){
            JOptionPane.showMessageDialog(null, "Found client.", "Sucess",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isSearch(String option) {
        if("2".equals(option)){
            return true;
        }
        return false;
    }

    private static void register(String data) {
        String[] splitData = data.split(",");
        Client client = new Client(splitData[0],splitData[1],splitData[2],splitData[3],splitData[4],splitData[5],splitData[6]);
        Boolean isRegistered = null;
        try{
            isRegistered = iClienteDAO.register(client);
            if(isRegistered){
                JOptionPane.showMessageDialog(null,"Sucess register","Sucess",JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null,"Client was already registered.","ERROR",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (TypeKeyNotFoundException e){
            JOptionPane.showMessageDialog(null,"Data updated with sucess", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isRegister(String option) {
        if ("1".equals(option)){
            return true;
        }
        return false;
    }

    private static boolean isLeaveOption(String option) {
        if("5".equals(option)){
            return true;
        }
        return false;
    }

    private static void leave() {
        JOptionPane.showMessageDialog(null,"See ya","Leave",JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isValidOption(String option) {
        if ("1".equals(option)|| "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option)){
            return true;
        }
        return false;
    }

}
