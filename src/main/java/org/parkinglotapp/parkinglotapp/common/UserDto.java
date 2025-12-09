package org.parkinglotapp.parkinglotapp.common;

public class UserDto {
    private Long id;         // Câmp nou
    private String username; // Redenumit din 'name'
    private String email;

    public UserDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // --- GETTERII SUNT OBLIGATORII PENTRU JSP ---

    public Long getId() { // Fără asta, ${user.id} crapă pagina
        return id;
    }

    public String getUsername() { // Fără asta, ${user.username} crapă pagina
        return username;
    }

    public String getEmail() {
        return email;
    }
}