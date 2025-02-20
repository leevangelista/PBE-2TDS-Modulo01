package banco;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserBd {

    private List<User> users;

    public UserBd() {
        this.users = new ArrayList<>();
    }

    //buscar todos os usuarios
    public List<User> findAll(){
    return new ArrayList<>(users);
}
    //buscar apenas um usuario
    public  User getById(long id){
    return users.stream()
            .filter( user -> user.getId() == id)
            .findFirst()
            .orElse(null);
    }
    // insert user
    public boolean insert(User user){
        users.add(user);
        return true;
    }

    //update user
    public boolean update(long id, User user) {
        User userBd = users.stream()
                .filter(objeto -> objeto.getId() == id)
                .findFirst()
                .orElse(null);


        if (userBd == null){
            return false;
        }
        userBd.setNome(user.getNome());
        userBd.setSobrenome(user.getSobrenome());

        return true;
    }
}


