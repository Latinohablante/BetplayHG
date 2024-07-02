
import com.ligabetplay.controller.AssignRole;
import com.ligabetplay.view.viewMenuPrincipal;

public class Main {
    public static void main(String[] args) {
        //Crear roles/usuarios por defecto
        AssignRole.createRoles();
        //Menu de inicio de sesion o registro
        viewMenuPrincipal.showMenu();
    }
}
