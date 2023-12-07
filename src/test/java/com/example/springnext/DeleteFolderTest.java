package com.example.springnext;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.springnext.service.FolderService;

@SpringBootTest
public class DeleteFolderTest {

    @MockBean
    private FolderService folderService;

    @Test
    public void testDeleteFolder() {
        Long folderId = 1L;

        folderService.deleteFolder(folderId);

        verify(folderService).deleteFolder(folderId);
    }
}
