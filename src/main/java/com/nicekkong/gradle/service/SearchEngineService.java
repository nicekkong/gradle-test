package com.nicekkong.gradle.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nicekkong.gradle.data.DocumentDAO;
import com.nicekkong.gradle.model.Document;
import com.nicekkong.gradle.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchEngineService implements SearchEngine {

    private DocumentDAO documentDAO;

    public SearchEngineService() {
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public List<Document> findByType(Type documentType) {
        List<Document>  result = new ArrayList<Document>();
        for (Document doc : listAll()) {
            if (doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }
        return result;
    }

    public List<Document> listAll() {
//        List<Document> result = Arrays.asList(documentDAO.getAll());
//        return result;
        return null;
    }

    public List<Document> findByLocation(String location) {

        throw new UnsupportedOperationException("findByLocation() is not implements yet");

    }

}