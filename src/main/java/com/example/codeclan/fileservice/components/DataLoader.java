package com.example.codeclan.fileservice.components;

import com.example.codeclan.fileservice.models.File;
import com.example.codeclan.fileservice.models.Folder;
import com.example.codeclan.fileservice.models.User;
import com.example.codeclan.fileservice.repositories.FileRepository;
import com.example.codeclan.fileservice.repositories.FolderRepository;
import com.example.codeclan.fileservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User user1 = new User("Accounts Payable");
        userRepository.save(user1);

        User user2 = new User("Admin");
        userRepository.save(user2);

        Folder folder1 = new Folder("Accounts", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Letters", user2);
        folderRepository.save(folder2);

        File file1 = new File("Invoice001", ".exe", 1.23, folder1);
        fileRepository.save(file1);

        File file2 = new File("Invoice002", ".exe", 1.45, folder1 );
        fileRepository.save(file2);

        File file3 = new File("Letter001", ".doc", 1.67, folder2);
        fileRepository.save(file3);


    }
}
