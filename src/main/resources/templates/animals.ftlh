<!DOCTYPE html>
<html>
<head>
    <title>Shelter</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Animal from shelter</h4>
<form action="/" method="get">
    Search by name: <input type="text" name="name"><br>
    <input type="submit" value="Search"/>
</form>
<#list animals as animal>
    <div>
        <p><b>${animal.type}</b> ${animal.name} | <a href="/product/${animal.id}">More information...</a></p>
    </div>
<#else>
    <h3>No any animals in shelter</h3>
</#list>
<hr>
<h3>Create new animal</h3>
<form action="/animal/create" method="post">
    </select><br><br>
    Type : <select size="3" multiple name="type">
        <option value="Cat">Cat</option>
        <option value="Dog">Dog</option>
        <option value="Other">Other</option>
    </select><br><br>
    Name: <input type="text" name="name"/><br><br>
    Size": <select size="3" multiple name="size">
        <option value="small">small</option>
        <option value="medium">medium</option>
        <option value="large">large</option>
    </select><br><br>
    Sex : <select size="2" multiple name="sex">
        <option value="Male">male</option>
        <option value="Female">female</option>
    </select><br><br>
    Age: <input type="number" name="age" min="1" max="100"/><br><br>
    Number: <input type="text" name="number"/><br><br>
    Number CHIP: <input type="number" name="chipNumber" /><br><br>
    Date of admission: <input type="date" name="dateOfAdmission"/><br><br>
    Status : <select size="5" multiple name="size">
        <option value="Quarantine">Quarantine</option>
        <option value="In shelter">In shelter</option>
        <option value="Adapted">Adapted</option>
        <option value="Put down">Put down</option>
        <option value="Died">Died</option>
    </select><br><br>
    Description: <input type="text" name="description"/><br><br>
    Load image: <input type="file" name="file1"/><br><br>
    Load image: <input type="file" name="file2"/><br><br>
    Load image: <input type="file" name="file3"/><br><br>
    <input type="submit" value="add a new dog"/>
</form>
</body>
</html>