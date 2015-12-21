/*
 * 2015. 12. 21.
 * Properties of nicekkong@gmail.com
 * Copyright (c) JE Foundation
 */

package com.nicekkong.gradle.data;

import com.nicekkong.gradle.model.Document;
import com.nicekkong.gradle.model.Type;
import org.springframework.core.io.Resource;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public class DocumentRepository implements DocumentDAO {

    private DataSource dataSource;
    private String queryAll;
    private Resource schema;
    private Resource data;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Document> getAll() {
        List<Document> result = new ArrayList<Document>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Document document = null;
        Type type = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryAll);
            while (resultSet.next()) {
                document = new Document();
                document.setDocumentId(resultSet.getString("documentId"));
                document.setName(resultSet.getString("name"));
                document.setLocation(resultSet.getString("location"));
                document.setCreated(resultSet.getDate("created"));
                document.setModified(resultSet.getDate("modified"));
                document.setDescription(resultSet.getString("doc_desc"));

                type = new Type();
                type.setTypeId(resultSet.getString("type_id"));
                type.setName(resultSet.getString("type_name"));
                type.setDesc(resultSet.getString("type_desc"));
                type.setExtension(resultSet.getString("extension"));
                document.setType(type);

                result.add(document);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void initial() {

        Connection connection = null;
        Statement statement = null;

        try {
            InputStream stream = schema.getInputStream();
            Scanner scanner = new Scanner(stream);
            StringBuilder sql = new StringBuilder();
            while (scanner.hasNext()) {
                sql.append(scanner.nextLine());
                sql.append("\n");
            }
            scanner.close();
            stream.close();

            try {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                statement.execute(sql.toString());
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                if(null != connection) {
                  try {
                      connection.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
                }
            }

            stream = data.getInputStream();
            scanner = new Scanner(stream);
            sql = new StringBuilder();

            while (scanner.hasNext()) {
                sql.append(scanner.nextLine());
                sql.append("\n");
            }
            scanner.close();
            stream.close();

            connection = null;
            statement = null;

            try {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(sql.toString());
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                if(null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
