package org.example;

import org.example.data.ResultData;

import java.io.BufferedReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class KanjiSearcher {
    private Map<Character, ResultData> database = new HashMap<Character,
            ResultData>();

    private void readCSV() throws Exception {
        var uri = getClass().getResource("/kanjiData.csv").toURI();

        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem
                fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        final Path path = fs.getPath(array[1]);

        var data = Files.readString(path, StandardCharsets.UTF_8);



        database = Arrays.stream(data.split("\n")).map(line -> {
            var fields =
                    Arrays.stream(line.split(";"))
                            .map(String::trim).toArray(String[]::new);

            return new ResultData(fields[1].charAt(0),
                                  Integer.parseInt(fields[0]),
                                  fields[2]);
        }).collect(Collectors.toMap(ResultData::kanji, ResultData::get));

        fs.close();
    }

    public KanjiSearcher() throws Exception  {
        readCSV();
    }

    public ResultData searchKanji(Character c) {
        return database.get(c);
    }

    public ResultData[] getAll() {
        return database.values().toArray(new ResultData[0]);
    }

    public ResultData[] searchKanjis(String text) {
        return text.codePoints()
                .mapToObj(c -> database.get((char)c))
                .filter(Objects::nonNull).toArray(ResultData[]::new);
    }
}
