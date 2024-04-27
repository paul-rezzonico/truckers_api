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

1. Pull the docker image from the docker hub
    ```sh
    docker pull iloveahri/truckers-api
    ```
   
2. Run the docker image
    ```sh
    docker run -p 8080:8080 -d --name "truckers-api" iloveahri/truckers-api
    ```
   
3. You can now access the API at http://localhost:8080/documentation


4. You can stop the docker image with
    ```sh
    docker stop truckers-api
    ```

## Technologies Used

- **Kotlin** ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
- **Spring** ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)
- **Docker** ![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
- **Junit** ![Junit](https://img.shields.io/badge/Junit-25A162?style=flat&logo=junit5&logoColor=white)

## Contribution

This project is not actually open to contribution.

## License

Shield: [![CC BY-NC-SA 4.0][cc-by-nc-sa-shield]][cc-by-nc-sa]

This work is licensed under a
[Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License][cc-by-nc-sa].

[![CC BY-NC-SA 4.0][cc-by-nc-sa-image]][cc-by-nc-sa]

[cc-by-nc-sa]: http://creativecommons.org/licenses/by-nc-sa/4.0/
[cc-by-nc-sa-image]: https://licensebuttons.net/l/by-nc-sa/4.0/88x31.png
[cc-by-nc-sa-shield]: https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-lightgrey.svg

---

Thank you for reading so far

---
