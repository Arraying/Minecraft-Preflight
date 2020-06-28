/* Copyright 2020 Arraying
 *
 * This file is part of Minecraft-Preflight (MCPF).
 *
 * MCPF is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MCPF is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MCPF. If not, see http://www.gnu.org/licenses/.
 */

package de.arraying.mcpf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.regex.Pattern;

public class MCPF {
    private static final Pattern DELIM = Pattern.compile("(.+)=");

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void premain(String agentArgs) throws IOException {
        // Get the unique identifier of the version.
        String identifier = System.getProperty("mcpf", "default");
        // Create the data directory if it doesn't exist.
        File mcpfFolder = new File("mcpf");
        mcpfFolder.mkdirs();
        // Create the file containing the overwrites if it does not exist.
        File overwritesFile = new File(mcpfFolder, identifier + ".txt");
        overwritesFile.createNewFile();
        // Get the Minecraft options file.
        File minecraftFile = new File("options.txt");
        if (!minecraftFile.exists()) {
            return;
        }
        // Load the overwrite properties.
        Properties overwritesProperties = new Properties();
        overwritesProperties.load(new FileInputStream(overwritesFile));
        // Load the Minecraft properties.
        Properties minecraftProperties = new Properties();
        minecraftProperties.load(new FileInputStream(minecraftFile));
        // Replace.
        overwritesProperties.forEach(minecraftProperties::put);
        // Save.
        minecraftProperties.store(new FileOutputStream(minecraftFile), null);
        // Use the proper delimiter.
        String minecraftContents = new String(Files.readAllBytes(minecraftFile.toPath()));
        minecraftContents = DELIM.matcher(minecraftContents).replaceAll("$1:");
        Files.write(minecraftFile.toPath(), minecraftContents.getBytes());
    }
}
