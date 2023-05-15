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