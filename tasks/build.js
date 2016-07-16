const gulp = require('gulp');
const sass = require('gulp-sass');
const minifyCss = require('gulp-minify-css');
const rename = require('gulp-rename');
const del = require('del')
const babel = require("gulp-babel");
const sourcemaps = require('gulp-sourcemaps');

gulp.task('clean', () => del('www'));

gulp.task('build', ['clean', 'install', 'assets', 'sass', 'compile']);

gulp.task('assets', () => {
  gulp.src('./src/assets/**/*', { base: 'src/assets' })
    .pipe(gulp.dest('./www'));
});

gulp.task('compile', () => {
  return gulp.src(['src/js/**/*.js'])
    .pipe(sourcemaps.init())
    .pipe(babel())
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest('www/js'));
});

gulp.task('sass', (done) => {
  gulp.src('./src/scss/ionic.app.scss')
    .pipe(sass())
    .on('error', sass.logError)
    .pipe(gulp.dest('./www/css/'))
    .pipe(minifyCss({
      keepSpecialComments: 0
    }))
    .pipe(rename({ extname: '.min.css' }))
    .pipe(gulp.dest('./www/css/'))
    .on('end', done);
});
