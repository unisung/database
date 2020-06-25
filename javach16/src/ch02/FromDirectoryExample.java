package ch02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;
//디렉토리로 부터 스트림 얻기
public class FromDirectoryExample {
	public static void main(String[] args) throws IOException {
	 Path path = Paths.get("c:/oracleworkspace");
	 Stream<Path> stream = Files.list(path);
	 stream.forEach(t->System.out.println(t.getFileName()));
	}

}
