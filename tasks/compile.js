const gulp = require('gulp');
const babel = require("gulp-babel");
const sourcemaps = require('gulp-sourcemaps');
const plumber = require("gulp-plumber");

gulp.task('compile', () => {
  return gulp.src(['src/js/**/*.js'])
    .pipe(plumber())
    .pipe(sourcemaps.init())
    .pipe(babel())
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest('www/js'));
});
