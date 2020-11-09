package com.thevoodoohuman.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "databaseId")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CustomTelegramUser {

    private static final String ID_FIELD = "id";
    private static final String FIRSTNAME_FIELD = "first_name";
    private static final String ISBOT_FIELD = "is_bot";
    private static final String LASTNAME_FIELD = "last_name";
    private static final String USERNAME_FIELD = "username";
    private static final String LANGUAGECODE_FIELD = "language_code";
    private static final String CANJOINGROUPS_FIELD = "can_join_groups";
    private static final String CANREADALLGROUPMESSAGES_FIELD = "can_read_all_group_messages";
    private static final String SUPPORTINLINEQUERIES_FIELD = "supports_inline_queries";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long databaseId;
    @JsonProperty(ID_FIELD)
    @NonNull
    private Integer id; ///< Unique identifier for this user or bot
    @JsonProperty(FIRSTNAME_FIELD)
    @NonNull
    private String firstName; ///< User‘s or bot’s first name
    @JsonProperty(ISBOT_FIELD)
    @NonNull
    private Boolean isBot; ///< True, if this user is a bot
    @JsonProperty(LASTNAME_FIELD)
    private String lastName; ///< Optional. User‘s or bot’s last name
    @JsonProperty(USERNAME_FIELD)
    private String userName; ///< Optional. User‘s or bot’s username
    @JsonProperty(LANGUAGECODE_FIELD)
    private String languageCode; ///< Optional. IETF language tag of the user's language
    @JsonProperty(CANJOINGROUPS_FIELD)
    private Boolean canJoinGroups; ///< Optional. True, if the bot can be invited to groups. Returned only in getMe.
    @JsonProperty(CANREADALLGROUPMESSAGES_FIELD)
    private Boolean canReadAllGroupMessages; ///< Optional. True, if privacy mode is disabled for the bot. Returned only in getMe.
    @JsonProperty(SUPPORTINLINEQUERIES_FIELD)
    private Boolean supportInlineQueries; ///< Optional. True, if the bot supports inline queries. Returned only in getMe.
}



