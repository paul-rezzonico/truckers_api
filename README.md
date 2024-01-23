# Truckers API

## Overview

<table>
  <tr>
    <td>
      <img src="Logo.png" width="150px" alt="Truckers API Logo"/>
    </td>
    <td>
      <p>Truckers API is a REST API that allows you to manage your messages send by truckers. 
      It's designed to work with the <a href="https://github.com/paul-rezzonico/truckers">Truckers mobile app</a>
    </p>
    </td>
  </tr>
</table>

## Table of Contents

- [Overview](#overview)
- [Table of Contents](#table-of-contents)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Technologies Used](#technologies-used)
- [Contribution](#contribution)
- [License](#license)

## Features

- **Get all messages** : Get all messages save on the API
- **Get a message** : Get a specific message by its id, author or date
- **Push all messages from a specific user** : Push all messages from a specific user to the API

## Getting Started

### Prerequisites

- **Docker** : ![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)

You need Docker to run the project, you can download it [here](https://www.docker.com/get-started)

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/paul-rezzonico/truckers_api.git
   ```
2. Build the docker image
   ```sh
    docker build --tag "truckers_api" .
    ```
3. Run the docker image
    ```sh
    docker run -p 8080:8080 -d --name "truckers_api" truckers_api
    ```
   
4. You can now access the API at http://localhost:8080


5. You can stop the docker image with
    ```sh
    docker stop truckers_api
    ```

## Technologies Used

- **Kotlin** ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
- **Spring** ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)
- **Docker** ![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
- **Junit** ![Junit](https://img.shields.io/badge/Junit-25A162?style=flat&logo=junit5&logoColor=white)

## Contribution

This project is not actually open to contribution.

## License

This project is under MIT license - see the LICENSE.md file for details.

---

Thank you for reading so far

---
