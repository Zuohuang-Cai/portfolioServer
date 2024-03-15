## Create a new user

- POST /admin/{username}{password} HTTP/1.1
- token : {token}
- Host: localhost:8080

## Login

- POST /login/{username}{password} HTTP/1.1
- Host: localhost:8080

## verify token

- GET /login/{token} HTTP/1.1
- Host: localhost:8080

## Store ip

- GET login/ip HTTP/1.1
- Host: localhost:8080

## add project

- POST /project/{Title}{Description}{Url}{Tag}{Fotofile} HTTP/1.1
- `fotofile`*(MultipartFile)*
- token : {token}

## get all projects

- GET /project/Allprojects HTTP/1.1
- Host: localhost:8080
- token : {token}

## get project by id

- GET /project/{id} HTTP/1.1
- Host: localhost:8080
- token : {token}

## edit project

- PUT /project/{id}{Title}{Description}{Url}{Tag}{Fotofile} HTTP/1.1
- `fotofile`*(MultipartFile)*
- token : {token}
- Host: localhost:8080

## delete project

- DELETE /project/{id} HTTP/1.1
- token : {token}
- Host: localhost:8080

## get Project foto

- GET /project/foto/{id} HTTP/1.1
- Host: localhost:8080
- token : {token}
- Response: image
