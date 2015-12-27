/*    private int id;
 private String name;
 private String description;
 private int playerId;
 private RoomAccessType accessType;
 private String password;
 private int rating;
 private String model;
 private boolean allowPets;
 private boolean allowPetsEating;
 private boolean disableBlocking;
 private String decorations;
 private String icon;
*/

module.exports = {
    name: {type: String, limit: 100},
    description: {type: String, limit: 200},
    playerId: { type: Number },
    accessType: { type: String, limit: 25 },
    password: { type: String, limit: 50 },
    rating: { type: Number },
    model: { type: String },
    allowPets: { type: String },
    allowPetsEating: { type: String },
    disableBlocking: { type: String },
    decorations: { type: String },
    icon: { type: String }
};