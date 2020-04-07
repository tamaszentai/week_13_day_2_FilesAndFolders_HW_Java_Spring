package com.codeclan.example.FilesAndFolders.components;

import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.User;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

@Autowired
    FileRepository fileRepository;

@Autowired
UserRepository userRepository;

@Autowired
FolderRepository folderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        folderRepository.deleteAll();
        userRepository.deleteAll();
        fileRepository.deleteAll();

        User tamas = new User("tamas");
        userRepository.save(tamas);

        User balazs = new User("balazs");
        userRepository.save(balazs);

        Folder music = new Folder("music", tamas);
        folderRepository.save(music);

        Folder documents = new Folder("documents", tamas);
        folderRepository.save(documents);

        File song1 = new File("song1", "mp3", 12345, music);
        fileRepository.save(song1);

        File song2 = new File("song2", "mp3", 54321, music);
        fileRepository.save(song2);

        File document1 = new File("document1", "pdf", 14, documents);


    }
}
