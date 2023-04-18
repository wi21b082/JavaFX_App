package at.technikum.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HelloController {

    @FXML
    private Label customerId;

    private String URI = "http://localhost:8080/invoice/";

    @FXML

    private TextField customerIdTextField;

    @FXML
    protected void getCustomerId() throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI + customerId.getText()))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String id = response.body();

        customerId.setText(id);

    }

    @FXML
    protected void sendCustomer() throws URISyntaxException, IOException, InterruptedException {

        String requestBody = customerIdTextField.getText();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String customerId = response.body();

        customerIdTextField.setText(customerId);
    }
    
}