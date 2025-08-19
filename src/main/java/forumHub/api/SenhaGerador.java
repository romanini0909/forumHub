package forumHub.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaGerador {

    public static void main(String[] args) {
        // Cria um objeto para criptografar a senha
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // A senha que queremos criptografar é "123456"
        String senhaOriginal = "123456";

        // Criptografa a senha
        String senhaCriptografada = encoder.encode(senhaOriginal);

        // Imprime a senha criptografada no console
        System.out.println("Sua senha criptografada: " + senhaCriptografada);
    }
}