Feature: Ionic

  Scenario: Start App
    Given I start App
    Then I should see main menu:
      | Reggae  |
      | Chill   |
      | Dubstep |
      | Indie   |
      | Rap     |
      | Cowbell |

  Scenario: Show Side Menus
    When I click side menu icon
    Then I should see menu items:
      | Login     |
      | Search    |
      | Browse    |
      | Playlists |

  Scenario Outline: Show Playlist
    When I click "<item>"
    Then I should see "<playlist>"
    Examples:
      | item    | playlist |
      | Reggae  | Playlist |
      | Chill   | Playlist |
      | Dubstep | Playlist |
      | Indie   | Playlist |
      | Rap     | Playlist |
      | Cowbell | Playlist |