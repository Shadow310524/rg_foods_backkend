    package com.example.rg.rg_foods_backend.controller;

    import com.example.rg.rg_foods_backend.model.LoginRequest;
    import com.example.rg.rg_foods_backend.model.User;
    import com.example.rg.rg_foods_backend.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    //Base Path
    @RequestMapping("/api/user")
    public class LoginController {
        @Autowired
        UserService userService;
        //Add User
        @PostMapping("/create")
        public ResponseEntity<String> addUser(@RequestBody User user){
            System.out.println("Working in console");
            userService.addUser(user);
            System.out.println("Works after method!!");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("✅ User added successfully: "+user.toString());
        }

//        Login Request
        @PostMapping("/login")
        public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest){
            System.out.println("Login method called");
            if(userService.getUserbyEmail(loginRequest)){
                System.out.println("Login worked");
                return ResponseEntity.ok()
                        .body("✅ Login Worked: "+loginRequest.toString());
            }
            return ResponseEntity
                    .status(401)
                    .body("Login Failed");
        }
        @GetMapping("/show")
        public ResponseEntity<List<User>> getUser(){
            return ResponseEntity.ok(userService.getAllUser());
        }
        @GetMapping("/{id}")
        public ResponseEntity<String> getUserById(@PathVariable int id){
            User obj=userService.getUserById(id);
            if(obj!=null)
                return ResponseEntity.ok("User Found:\n "+ obj.toString());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found with ID:"+id);
        }
    }
