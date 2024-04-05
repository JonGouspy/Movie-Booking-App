#Jon Gouspy 74538

##Movie screen:##
✔️ Create a Movie class with the structure specified in movie.json\
✔️ Obtain and fill data (minimum of 4 movies)\
✔️ Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app\
✔️ Generate a random number between 0 and 15 for each movie and assign to seats_remaining\
✔️ Start with an initial default seats_selected value of 0 for all movies\
✔️ You shall fill random URLs for images from pixabay or other free image providers to begin with\
✔️ If any seats are selected, show how many seats are selected and hide remaining seats\

##Seat selection feature:##
✔️ Clicking any item (anywhere on the item) on the movie screen should open a new MovieActivity, refer to movie_activity_*.jpg
✔️ Add plus and minus icons, show seats_selected in the middle
✔️ On click plus/minus, update both seats_selected and seats_remaining for that movie
✔️ Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
✔️ When back is pressed, the selected seats are retained and reflected in the screen. (Hint: If you don’t see any updates, call adapter notifyItemChanged as soon as you return to the screen activity)

##Bonus:##
✖️ Add "filling fast" badge if less than 3 seats remaining.
✖️ Use "Roboto Condensed" font to replicate same style.
✔️ Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif).
