package com.example.springnext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.springnext.model.Folder;
import com.example.springnext.model.User;
import com.example.springnext.service.FolderService;

@SpringBootTest
public class CreateFolderTest {

    @MockBean
    private FolderService folderService;

    @Test
    public void testCreateFolder() {
        User mockUser = mock(User.class);

        Folder newFolder = new Folder();
        newFolder.setName("TestFolder");
        newFolder.setUser(mockUser);

        when(folderService.createFolder("TestFolder", mockUser)).thenReturn(newFolder);

        Folder createdFolder = folderService.createFolder("TestFolder", mockUser);

        assertNotNull(createdFolder);
        assertEquals("TestFolder", createdFolder.getName());
        assertEquals(mockUser, createdFolder.getUser());

        verify(folderService).createFolder("TestFolder", mockUser);
    }
}
