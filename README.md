# Instructions

Upon cloning the repository, you need to run `docker compose up`. And a server will start on `localhost:5173`

# Part 1

As part of our Web Engineering project, we carefully selected the technologies based on both our current skill set and our eagerness to embrace new challenges. Here's an overview of our choices and the rationale behind them: <br><br>
**Backend: Java Spring**<br>
Our decision to use Java Spring for the backend was a natural extension of our journey in learning Java. We had our initial exposure to Java in the "Object-Oriented Programming" course during the second block of our first year. This course laid the foundation for our understanding of Java's capabilities. Building upon this, in the first block of our second year, we delved deeper into Java through the "Advanced Object-Oriented Programming" course. These courses equipped us with a solid grasp of Java's core concepts, making Java Spring a logical choice for our backend development. We chose Java Spring for our backend due to its robustness, ease of integration, and our familiarity with Java from previous courses, enhancing both development efficiency and application scalability.<br><br>
**Frontend: React**<br>
For the frontend, we ventured into new territory with React. Our coursework had not previously covered frontend development in depth, so we saw this project as an opportunity to step out of our comfort zone. React, renowned for its high demand in the market, was an attractive choice for us. It promised not only to enhance our employability skills but also to introduce us to modern web development practices.
React's component-based architecture appealed to us for its modularity and reusability, which aligns well with the principles we learned in object-oriented programming. Moreover, React's abundant resources, and beginner-friendly nature made our transition into frontend development smoother and more manageable. Learning React has been an exciting challenge, allowing us to gain hands-on experience in building dynamic and interactive user interfaces.<br><br>
**Database: MongoDB**<br>
The choice of MongoDB as our database technology was influenced by our coursework in "Program Analysis and Software Development," offered in the second block of our second year. An intriguing part of this course involved analyzing the acquisition of Realm by MongoDB. This deep dive into Realm's repository indirectly led us to explore and understand the workings of MongoDB Cloud.
MongoDB, being a NoSQL database, resonated with us for its flexibility in handling unstructured data, which is a common requirement in modern web applications. Its schema-less nature offered us the freedom to develop without being bound to a rigid structure, a feature we found particularly useful given the dynamic nature of our project. Additionally, MongoDB's ease of use and its ability to scale effortlessly made it a fitting choice for our application's database needs.
In conclusion, our technology stack, comprising Java Spring, React, and MongoDB, was chosen not just for its alignment with our current expertise and academic exposure but also for its relevance in the evolving landscape of web development. This project has been a journey of both applying our foundational knowledge and embracing new technologies, a balance that we believe is crucial in the ever-changing field of computer science.

# Part 2

**REQ 1**<br>

1. Our API effectively manages population and GDP data for countries, identified by name or ISO code, for a given year. The `CountryData` schema allows users to retrieve (GET), create (POST), update (PUT), and delete (DELETE) information.
2. The `EmissionsData` endpoint in our API provides comprehensive access to emissions-related data, including CO2, methane, nitrous oxide, and total greenhouse gases for any specified country. Users can easily filter data from a particular year onwards, utilizing either the country's name or ISO code for identification.
3. Our API's `TemperatureChangeData` endpoint caters to the need for detailed climate information by providing temperature change data per continent. Users have the option to filter the data from a specified year onwards.
4. Through the `EnergyData` endpoint, our API delivers vital statistics on energy usage per capita and per GDP for all countries in a given year. The data is sortable by population size and available in batches of 10, 20, 50, or 100.
5. The `ClimateChange` endpoint in our API is designed to provide crucial insights into the impact of different countries on climate change. It allows users to retrieve the top or bottom N countries based on their share of temperature change from greenhouse gases, either for a specific year or over the past M years.

**REQ 2**<br>
In accordance with REQ2, each of our API endpoints has been designed to support both JSON and CSV formats for resource representations. The default response format for all endpoints is set to JSON (application/json). Additionally, our API provides CSV (text/csv) support for those that prefer or require data in a tabular form. By offering both JSON and CSV formats and setting JSON as the default, our API ensures a balance between modern web standards and the versatility required by various consumer applications. Importantly, we strictly avoid returning HTML representations, even in error scenarios, to maintain consistency in response formats and to adhere to the principles of a RESTful API.

**REQ 3**<br>
Our API documentation details each endpoint, conforming to REQ3 by including the necessary elements to provide a comprehensive understanding of the API's capabilities. <br>
For instance, the endpoint /countries/{country_code}/data/{year} is documented with its name and functionality clearly stated: it retrieves the population and GDP for a specified country and year. Access details are outlined, specifying the path parameters country_code and year for clients to supply. The accepted and returned representations are thoroughly described, with JSON and CSV formats supported.
Within the components section, schemas define the data structures for CountryData, EmissionsData, TemperatureChangeData, EnergyData, and ClimateChangeContributionData. These schemas are referenced in the paths section, ensuring consistency and clarity in how data is represented and exchanged.<br>
Responses for each endpoint are detailed, including successful and error responses. The '200' success response is described for each operation along with the response content, specifying the schema that defines the structure of the response data. Error responses are enumerated with common errors like 'BadRequest', 'NotFound', 'NoResults', and 'ServerError', each with a clear description and content type.

**REQ 4**<br>
In alignment with REQ4, our team has implemented the backend of the web application by adopting the Model-View-Controller (MVC) architectural pattern, leveraging the strengths of Java Spring. This framework facilitates the organized development of high-performance and scalable RESTful APIs, allowing for clear separation of concerns – with models defining the data structure, controllers handling the request-response cycle, and views responsible for returning the correct representation to the client.<br>
To ensure data persistence, we have integrated MongoDB, a NoSQL database, which provides a flexible schema ideal for storing and querying our data efficiently. This choice complements the MVC structure, with models seamlessly mapping to MongoDB collections and documents.<br>
The entire backend implementation has been meticulously documented using JavaDoc comments.

**REQ 5**<br>
In alignment with REQ5, our web application features an intuitive user interface that provides straightforward access to all API functionalities. Key aspects of our UI include:<br>
Landing Page: Upon arrival, users are greeted with a landing page that provides an overview of the web application, including its purpose and capabilities. This introductory page sets the tone for user interaction and guides them on how to navigate through the app.<br>

Sidebar Navigation: A key element of our UI is the sidebar navigation, positioned on the left side of the screen. This sidebar houses a series of buttons, each corresponding to a specific action available through our API. This approach ensures that users have all functionalities at their fingertips, facilitating easy and direct access to various data points such as temperature, emissions, energy details, and more.<br>
In our application, each form on the frontend plays a crucial role in bridging the user interface with our backend services, primarily through a function named handleSubmit. When a user fills out a form and submits it, the function handleSubmit first safely processes and encodes the user inputs, ensuring they are ready for transmission to the backend. It then dynamically constructs a request URL that corresponds to the specific API endpoint designed to handle the requested operation, be it fetching, updating, or deleting data.
Depending on the form’s purpose and the nature of the request, this could be a GET, POST, PUT, or DELETE request. Once the backend processes this request and sends back a response, handleSubmit manages the received data. It checks the desired format specified by the user—JSON or CSV—and formats the data accordingly.
In our web application, we have designed the user interface to be as intuitive and user-friendly as possible. Each functionality, corresponding to an API endpoint, is represented by a button on the sidebar. These buttons act as direct links to the various actions users can perform, ensuring that all features are just a click away.

The actions available through our frontend, each linked to a specific button on the sidebar, include:

- Creating a New CountryData: This button enables users to input and submit new data related to a country's population and GDP.

- Retrieving CountryData Information: Users can view detailed information about a country, including its population and gdp indicators.

- Creating CountryData Information: Users can create information about a country, including its population and gdp indicators.

- Updating CountryData Information: This functionality allows users to modify existing country data, ensuring the application remains up-to-date and accurate.

- Deleting a CountryData: If there's a need to remove a country's data from the database, users can do so using this option.

- Retrieving Emission Information: Users can access data on various emissions metrics for different countries.

- Retrieving Energy Details: This feature provides information on energy across different nations.

- Retrieving Temperature Information: For insights into temperature data users can use this button.

- Retrieving Temperature Change Information: This option offers access to data on temperature changes over time.

By organizing these functionalities in a clear and accessible manner on the sidebar, our application ensures that users can easily navigate and utilize the full range of features offered by our API, enhancing the overall user experience.

**REQ 6**<br>
Our application fulfills Requirement 6 by providing a docker-compose.yml file that ensures the entire application stack, including both the backend and frontend services, can be started with a single command: "docker-compose up". This configuration is designed to meet the expectation of simplicity and convenience of running the project.<br><br>
In our docker-compose.yml, we define two services: backend and frontend. Each service is configured to build its respective Docker image using custom Dockerfiles located in the backend and frontend directories. This ensures that our application is containerized and isolated, promoting consistent behavior across different environments.<br><br>

- Backend Service: For the backend, our Dockerfile first uses Gradle to prepare the necessary Java files. We set it up in steps to keep things readable,clean and efficient. Afterwards it compiles everything, and then it runs the compiled application. This method helps keep our application lean and fast, focusing only on what's needed to run it.

- Frontend Service: Similarly, for the frontend, we use Node.js to build our React application. The build process compiles our React code and then serves it using a lightweight server. Again, the multi-stage build process helps in reducing the final image size.

# Part 3

1.  Level 1 - Resources: Our API clearly defines various resources, such as countries, emissions, and temperature-change. This is evident from the distinct endpoints in the specification, aligning with Level 1 of RMM where each resource has its own URL.
2.  Level 2 - HTTP Verbs: We've successfully integrated the use of HTTP verbs like GET, POST, PUT, and DELETE in our API. This aligns with CRUD operations, where GET is used for data retrieval, POST for creating new records, PUT for updating existing records, and DELETE for removing records. This adoption of HTTP verbs suggests that our API fits into Level 2 of the RMM.

**Potential Issues**<br>
Absence of Hypermedia Controls (HATEOAS): Our API currently does not implement HATEOAS (Hypermedia as the Engine of Application State), a key aspect of a fully RESTful service as per the Richardson Maturity Model Level 3. HATEOAS introduces hypermedia controls, which essentially guide the client on the next valid state change operations on a resource.

# Part 4

In our project, we emphasized a collaborative approach, where all group members worked together on every aspect. We held regular meetings to discuss and solve problems collectively. This approach ensured a cohesive understanding and contribution to each part of the project. We also utilized IntelliJ's Code With Me feature, allowing real-time collaboration, code sharing, and simultaneous coding sessions. This tool significantly enhanced our teamwork, making our development process more efficient and integrated.

# Utilization of Generative AI in the Project + sources

In this project, our team engaged with an AI tool to support our understanding and development processes. Specifically, we used ChatGPT, under a paid subscription, to enhance our comprehension of Docker and to address minor debugging issues. The extent of our reliance on ChatGPT was limited, focusing mainly on obtaining explanations and troubleshooting tips rather than generating extensive code or documentation.

Our interaction with ChatGPT involved creating specific prompts to extract relevant information. These included queries aimed at clarifying Docker concepts and seeking advice for resolving straightforward Docker-related problems. The effort required to identify these appropriate prompts was rather small. Integrating the outcomes from ChatGPT into our project was a streamlined process, as the responses were primarily used for conceptual understanding and immediate problem-solving.

Alongside ChatGPT, we also leveraged educational content available on YouTube to further our understanding of Docker and MongoDB. Two notable videos that significantly contributed to our project were https://www.youtube.com/watch?v=qVNOw9TWwxo and https://www.youtube.com/watch?v=g0QCZSzEqCY . These videos provided practical demonstrations and visual explanations that complemented the textual information obtained from ChatGPT. We found that this approach effectively bridged the gap between theoretical knowledge and practical application. While ChatGPT provided quick, targeted answers to specific queries, the YouTube videos offered a broader, more practical perspective.

# Bonuses

**Bonus nr.2 - Third Party API**

Our web application successfully incorporates a third-party API to enhance user engagement, fulfilling the bonus criterion of the assignment. We integrated the Cat Facts API, accessed via a dedicated button on the sidebar. When users click this button, they receive a random cat fact. This integration not only adds an element of fun to our application but also demonstrates our proficiency in implementing external APIs to provide additional, dynamic content to our users.

**Bonus nr.3 - Multiple Containers**

Our application effectively meets the bonus requirement of deploying different application tiers across multiple containers. We utilized Docker to containerize both the frontend and backend, ensuring isolated and consistent environments for each. The docker-compose.yml file orchestrates these containers, allowing them to work together while maintaining their separation. This setup not only simplifies deployment but also aligns with best practices in modern software development, demonstrating our competency in utilizing this technology.

**Bonus nr.4 - Appropriate Design Pattern**

In our project, we applied design principles and patterns that we've studied throughout the course. Specifically, we implemented the Model-View-Controller (MVC) architecture in our backend, which is evident from the structured organization of our directories and files. This design pattern is a best practice within software engineering for creating web applications because it promotes separation of concerns—organizing the application into three interconnected components. This separation enhances maintainability, scalability, and collaboration on the codebase.
The adoption of MVC and other principles from the course is also thoroughly rationalized in our report. This approach not only aligns with academic teachings but also reflects industry standards, demonstrating our understanding of both theory and its practical application.
