# RestApi_V1

# RestAPI

Kucuk Tasklar ile Spring Boot Rest API geliştirme

## API Kullanımı

#### Get All User record

```http
  GET /api/users
  GET /api/users?page=1&size=5
```

| Parametre | Tip      | Açıklama                                              |
|:----------|:---------|:------------------------------------------------------|
| `page`    | `string` | return page, default page size is 0                   |
| `size`    | `string` | return size of items in page , default page size is 3 |

#### Get User base on it's id

```http
  GET /api/users/${userId}
```

| Parametre | Tip      | Açıklama                                  |
|:----------|:---------|:------------------------------------------|
| `userId`  | `string` | **Must**. The id of the item to be called |

#### Yeni User bilgisini DB'ye kayıt eder

```http
  POST /api/users/
```

| Parametre    | Tip      | Açıklama |
|:-------------|:---------|:---------|
| Request Body |
| `h_no`       | `int`    |
| `sicil_no`   | `int`    |
| `username`   | `string` |
| `password`   | `string` |
| `firstname`  | `string` |
| `lastname`   | `string` |
| `role_id`    | `int`    |
| `status`     | `string` |
| `attributes` | `string` |
| `inserttime` | `int`    |
| `updatetime` | `int`    |

#### search method with 'post'

```http
  POST /api/users/search
```

| Parametre           | Tip      | Açıklama                                                  |
|:--------------------|:---------|:----------------------------------------------------------|
| Request Body        |
| `gLobalOperator`    | `string` | `AND - OR`                                                |
| `searchRequestDTOs` | `List`   | `column , value , operation`                              |
| `column`            | `string` | `username, firstname,lastname`                            |
| `value`             | `string` | `column value`                                            |
| `operation`         | `string` | `EQUAL, LIKE, IN, GREATER_THAN, LESS_THAN, BETWEEN, JOIN` |

###example of search method

    {
    "gLobalOperator": "AND",
    "searchRequestDTOs":[
        {
            "column":"username",
            "value":"user16, user15",
            "operation":"IN"
        }
                        ]
    }

#### Delete User recod from DB

```http
  DELETE /api_v1/users/${userId}
```

| Parametre | Tip      | Açıklama                                  |
|:----------|:---------|:------------------------------------------|
| `userId`  | `string` | **Must**. The id of the item to be called |
