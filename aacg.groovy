@Grapes([
    @Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1'),
    @Grab(group='commons-logging', module='commons-logging', version='1.2'),
    @Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.13')
])

import groovyx.net.http.RESTClient

import java.net.HttpURLConnection
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Base64

// Set your Jira API URL and JQL query
def apiUrl = 'https://your-jira-instance/rest/api/2/search'
def jqlQuery = 'project = "Your Project" AND status = "Open"'

// Set your basic authentication password
def basicAuthPassword = 'your_basic_auth_password'

// Encode the password for basic authentication
def authHeaderValue = "Basic " + Base64.getEncoder().encodeToString((":${basicAuthPassword}").getBytes())

// Create the HTTP connection
def url = new URL(apiUrl + "?jql=${URLEncoder.encode(jqlQuery, 'UTF-8')}")
def connection = url.openConnection()

// Set the request method and authentication header
connection.setRequestMethod("GET")
connection.setRequestProperty("Authorization", authHeaderValue)

// Get the response
def responseCode = connection.getResponseCode()
def responseMessage = connection.getResponseMessage()

if (responseCode == 200) {
    // Read and print the response
    def reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))
    def response = reader.lines().collect().join('\n')
    println(response)
} else {
    println("Error: ${responseCode} - ${responseMessage}")
}
