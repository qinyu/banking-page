const gulp = require('gulp');
const sass = require('gulp-sass');
const minifyCss = require('gulp-minify-css');
const rename = require('gulp-rename');
const del = require('del');
const plumber = require("gulp-plumber");
const webpack = require('webpack-stream');
const webpackConfig = require('./webpack.config.js');

gulp.task('clean', () => del('www'));

gulp.task('build', ['clean', 'install', 'assets', 'sass', 'webpack']);

gulp.task('assets', () => {
  gulp.src('./src/assets/**/*', { base: 'src/assets' })
    .pipe(gulp.dest('./www'));
});

gulp.task('webpack', () => {
  return gulp.src('./src/js/app.js')
    .pipe(plumber())
    .pipe(webpack(webpackConfig), null, function(err, stats) {
      console.log(stats);
    })
    .pipe(gulp.dest('./www/js'))
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
