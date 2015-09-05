/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z4_printtreevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.*;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author ja
 */
public class ConsoleFileVisitor implements FileVisitor<Path> {
    String indent = "";
    @Override
    public FileVisitResult preVisitDirectory(Path t, BasicFileAttributes bfa) throws IOException {
        System.out.println(indent + "+" + t.getFileName());
        indent += "|  ";
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) throws IOException {
        System.out.println(indent + "-" + t.getFileName());
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path t, IOException ioe) throws IOException {
        return SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path t, IOException ioe) throws IOException {
        indent = indent.substring(0, indent.length() - 3);
        return CONTINUE;
    }
    
}
