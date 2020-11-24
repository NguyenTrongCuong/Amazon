package main.model.product.factory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class SaveProductImage {
	
	public static void saveImage(MultipartFile image, String path) throws IOException {
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path, image.getOriginalFilename())));
			outputStream.write(image.getBytes());
			outputStream.flush();
			outputStream.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
