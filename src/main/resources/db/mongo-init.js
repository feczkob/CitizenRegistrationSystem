db.createUser(
    {
        user: "crs",
        pwd: "crs",
        roles: [
            {
                role: "readWrite",
                db: "citizen"
            }
        ]
    }
);

db = new Mongo().getDB("citizen");

db.createCollection('citizen', { capped: false });

db.citizen.createIndex({_id:1})
db.citizen.createIndex({idNumber:1}, {unique: true})
