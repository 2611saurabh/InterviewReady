package org.spring.GoogleDocs_1.goodDesgine;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//interface for document element
interface DocumnentElement{

    public abstract String render();
}


// Concrete implementation for text elements
class TextElements implements DocumnentElement {

    private String text;

    public TextElements(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return text;
    }
}

// Concrete implementation for image elements
class ImageElements implements DocumnentElement {

    private String path;

    public ImageElements(String path){
        this.path = path;
    }

    @Override
    public String render(){
        return "[Image " + path+ "]";
    }
}

// NewLineElement represents a line break in the document.
class NewLineElement implements DocumnentElement {
    @Override
    public String render() {
        return "\n";
    }
}

// TabSpaceElement represents a tab space in the document.
class TabSpaceElement implements DocumnentElement {
    @Override
    public String render() {
        return "\t";
    }
}


// Document class responsible for holding a collection of elements
class Document {
    private List<DocumnentElement> documentElements = new ArrayList<>();

    public void addElement(DocumnentElement element) {
        documentElements.add(element);
    }

    // Renders the document by concatenating the render output of all elements.
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumnentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}
// Persistence Interface
interface Persistence {
    void save(String data);
}

// FileStorage implementation of Persistence
class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try {
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

// Placeholder DBStorage implementation
class DBStorage implements Persistence {
    @Override
    public void save(String data) {
        // Save to DB
    }
}

// DocumentEditor class managing client interactions
class DocumentEditor {
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElements(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElements(imagePath));
    }

    // Adds a new line to the document.
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    // Adds a tab space to the document.
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument() {
        storage.save(renderDocument());
    }
}

public class DocumentEditorClient {

    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}
