const gulp = require('gulp');
const paths = {
  sass: ['./scss/**/*.scss']
};

gulp.task('watch', function() {
  gulp.watch(paths.sass, ['sass']);
});
